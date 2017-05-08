package Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import database.MySQLConnection;

public class LogView {
	
	public static void showLogForUserId(int userID) {
		
		PreparedStatement pstmt = null;
		try {
			pstmt = MySQLConnection.getMySQLConnection().prepareStatement(
					"SELECT timeRegister, ID, message "
					+ "FROM USUARIOS "
					+ "INNER JOIN REGISTROS "
					+ "ON USUARIOS.ID = REGISTROS.userId "
					+ "WHERE USUARIOS.ID = ? "
					+ "ORDER BY timeRegister ASC;");
			pstmt.setInt(1, userID);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String timeRegister = rs.getString("timeRegister");
				String userId = rs.getString("ID");
				String message = rs.getString("message");
				
				String output = String.format("%s - %s - %s", timeRegister, userId, message);
				System.out.println(output);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
