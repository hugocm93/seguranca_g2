package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

import Util.Authentication;
import database.MySQLConnection;

public class UserDAOBDImplementation implements UserDAO {

	private static UserDAOBDImplementation instance = null;

	public static UserDAOBDImplementation getInstance() {
		if (instance == null) {
			instance = new UserDAOBDImplementation();
		}
		return instance;
	}

	protected UserDAOBDImplementation() {
		Statement stmt = null;
		try {
			stmt = MySQLConnection.getMySQLConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(MySQLConnection.statusConnection());

		String sql = "CREATE TABLE USUARIOS (" + 
				     " ID int NOT NULL AUTO_INCREMENT, " + 
				     " certificate LONGTEXT, " + 
				     " salt VARCHAR(100), " + 
				     " privateKeyBase64 VARCHAR(1000), " + 
				     " acesses INTEGER, " + 
				     " users INTEGER, " + 
				     " listings INTEGER, " + 
				     " queries INTEGER, " + 
				     " groupId INTEGER, " + 
				     " allowAccessAfter TIMESTAMP, " + 
				     " passwordHash BLOB, " + 
				     " PRIMARY KEY ( id ))";		
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			if(e.getErrorCode() != 1050){ //Código para já table já existente
				e.printStackTrace();
			}	
		}
		
		User user1 = new User();
		user1.set_group(Group.Administrador);
		user1.set_allowAccessAfter(new Timestamp(System.currentTimeMillis()));
		
		Scanner scanner = null;
		try {
			scanner = new Scanner( new File("Pacote-T3/Keys/admin-x509.crt") );
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String text = scanner.useDelimiter("\\A").next();
		scanner.close(); 
		user1.set_pemCertificate(text);		
		
		String salt = (String)user1.get_loginName().substring(0, 9);
		user1.set_salt(salt);
		
		String mockPassword = "162534";
		user1.set_passwordHash(Authentication.calcStringHash(mockPassword + salt));
		
		user1.setTotalAcesses(1);
		user1.setTotalListings(1);
		user1.setTotalQueries(1);
		user1.setTotalUsers(1);
	
		addUser(user1);
	}

	@Override
	public boolean addUser(User user) {
		System.out.println(MySQLConnection.statusConnection());

		String sql = "INSERT INTO USUARIOS (certificate, salt, privateKeyBase64, " + 
		"acesses, users, listings, queries, groupId, allowAccessAfter, passwordHash) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = MySQLConnection.getMySQLConnection().prepareStatement(sql);
			pstmt.setString(1, user.get_pemCertificate());
			pstmt.setString(2, user.get_salt());
			pstmt.setString(3, user.getPrivateKeyBase64());
			pstmt.setInt(4, user.getTotalAcesses());
			pstmt.setInt(5, user.getTotalUsers());
			pstmt.setInt(6, user.getTotalListings());
			pstmt.setInt(7, user.getTotalQueries());
			pstmt.setInt(8, user.get_group().ordinal());
			pstmt.setTimestamp(9, user.get_allowAccessAfter());
			pstmt.setBytes(10, user.get_passwordHash());

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return null;
	}

}
