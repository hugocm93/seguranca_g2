package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import database.MySQLConnection;

public class GroupDAOBDImplementation {
	
	private static GroupDAOBDImplementation instance = null;

	public static GroupDAOBDImplementation getInstance() {
		if (instance == null) {
			instance = new GroupDAOBDImplementation();
		}
		return instance;
	}
	
	protected GroupDAOBDImplementation() {
		Statement stmt = null;
		try {
			stmt = MySQLConnection.getMySQLConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(MySQLConnection.statusConnection());

		String sql = "CREATE TABLE GRUPOS (" + 
				     " groupId INTEGER, " +
				     " name VARCHAR(150), " +
				     " PRIMARY KEY ( groupId ))";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			if(e.getErrorCode() != 1050){ //Código para já table já existente
				e.printStackTrace();
			}	
		}
	}
	
	public void populateDataBase() {
		insertOnBD("INSERT INTO GRUPOS (groupId, name) VALUES (0,\"Administrador\")");
		insertOnBD("INSERT INTO GRUPOS (groupId, name) VALUES (1,\"Usuário\")");
	}
	
	private void insertOnBD(String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = MySQLConnection.getMySQLConnection().prepareStatement(sql);
		} catch (SQLException e1) {
			return;
		}
		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			return;
		}
	}
}