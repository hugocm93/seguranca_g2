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

		System.out.println(MySQLConnection.statusConnection());

		String sql = "CREATE TABLE MENSAGENS (" + 
				     " messageId int NOT NULL, " +
				     " message VARCHAR(350), " +
				     " PRIMARY KEY ( messageId ))";		
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			if(e.getErrorCode() != 1050){ //Código para já table já existente
				e.printStackTrace();
			}	
		}
	}
	
	public void populateDataBase() {
		insertOnBD("INSERT INTO MENSAGENS (messageId, message) VALUES (1001,\"Sistema iniciado.\")");
		insertOnBD("INSERT INTO MENSAGENS (messageId, message) VALUES (1002,\"Sistema encerrado.\")");
		
		insertOnBD("INSERT INTO MENSAGENS (messageId, message) VALUES (2001,\"Autenticação etapa 1 iniciada.\")");
		insertOnBD("INSERT INTO MENSAGENS (messageId, message) VALUES (2002,\"Autenticação etapa 1 encerrada.\")");
		insertOnBD("INSERT INTO MENSAGENS (messageId, message) VALUES (2003,\"Login name <login_name> identificado com acesso liberado.\")");
		insertOnBD("INSERT INTO MENSAGENS (messageId, message) VALUES (2004,\"Login name <login_name> identificado com acesso bloqueado.\")");
		insertOnBD("INSERT INTO MENSAGENS (messageId, message) VALUES (2005,\"Login name <login_name> não identificado.\")");
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
