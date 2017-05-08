package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import database.MySQLConnection;

public class MessageDAOBDImplementation {
	
	private static MessageDAOBDImplementation instance = null;

	public static MessageDAOBDImplementation getInstance() {
		if (instance == null) {
			instance = new MessageDAOBDImplementation();
		}
		return instance;
	}
	
	protected MessageDAOBDImplementation() {
		Statement stmt = null;
		try {
			stmt = MySQLConnection.getMySQLConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = "CREATE TABLE MENSAGENS (" + 
				     " messageId int NOT NULL, " +
				     " message LONGTEXT, " +
				     " PRIMARY KEY ( messageId ))";		
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			if(e.getErrorCode() != 1050){ //Código para já table já existente
				e.printStackTrace();
			}	
		}
	}
	
	public void insertOnBD(int id, String message) {
		String sql = "INSERT INTO MENSAGENS (messageId, message) VALUES ("+id+",'"+message+"')";
		PreparedStatement pstmt = null;
		try {
			pstmt = MySQLConnection.getMySQLConnection().prepareStatement(sql);
		} catch (SQLException e1) {
			return;
		}
		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			//System.out.println(e);
			return;
		}
	}

}
