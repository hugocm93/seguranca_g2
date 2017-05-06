package model;

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

		System.out.println(MySQLConnection.statusConnection());

		String sql = "CREATE TABLE REGISTROS (" + 
				     " registerId int NOT NULL AUTO_INCREMENT, " + 
				     " userId int NOT NULL, " + 
				     " messageId int NOT NULL, " + 
				     " message VARCHAR(350), " + 
				     " timeRegister VARCHAR(50), " +
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

}
