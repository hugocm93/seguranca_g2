package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import database.MySQLConnection;

public class RegisterDAOBDImplementation {
	
	private static RegisterDAOBDImplementation instance = null;

	public static RegisterDAOBDImplementation getInstance() {
		if (instance == null) {
			instance = new RegisterDAOBDImplementation();
		}
		return instance;
	}
	
	protected RegisterDAOBDImplementation() {
		Statement stmt = null;
		try {
			stmt = MySQLConnection.getMySQLConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = "CREATE TABLE REGISTROS (" + 
				     " registerId int NOT NULL AUTO_INCREMENT, " + 
				     " userId int, " + 
				     " messageId int NOT NULL, " + 
				     " message LONGTEXT, " + 
				     " timeRegister TEXT, " +
				     " PRIMARY KEY ( registerId ), " +
				     " FOREIGN KEY ( userId ) REFERENCES USUARIOS(ID), " + 
				     " FOREIGN KEY ( messageId ) REFERENCES MENSAGENS(messageId))";		
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			if(e.getErrorCode() != 1050){ //Código para já table já existente
				e.printStackTrace();
			}	
		}
	}
	
	public void insertOnBD(Register r) {
		String sql = "INSERT INTO REGISTROS (userId, messageId, message, timeRegister) VALUES (?,?,?,?)";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = MySQLConnection.getMySQLConnection().prepareStatement(sql);
			if(r.getUserId() != -1) {
				pstmt.setInt(1, r.getUserId());
			} else {
				pstmt.setString(1, null);
			}
			pstmt.setInt(2, r.getMessageId());
			pstmt.setString(3, r.getMessageComplete());
			pstmt.setString(4, r.getTimeRegister());
			
		} catch (SQLException e1) {
			return;
		}
		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			return;
		}
	}

}
