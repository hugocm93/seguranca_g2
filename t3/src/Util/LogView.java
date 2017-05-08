package Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import database.MySQLConnection;

public class LogView {
	
	public static void showLog() {
		
		PreparedStatement pstmt = null;
		try {
			pstmt = MySQLConnection.getMySQLConnection().prepareStatement(
					"SELECT * "
					+ "FROM REGISTROS "
					+ "ORDER BY registerId ASC;");
			
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("registerId | messageId | timeRegister | message");
			while(rs.next()) {
				String registerId = rs.getString("registerId");
				//String userId = rs.getString("userId");
				String messageId = rs.getString("messageId");
				String message = rs.getString("message");
				//String timeRegister = rs.getString("timeRegister");
				
				String output = String.format("%s - %s - %s", registerId, messageId, message);
				System.out.println(output);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
