package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

public class UserDAOMockImplementation implements UserDAO{
	
	ArrayList<User> _users = new ArrayList<User>();
	
	public UserDAOMockImplementation(){
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
		user1.set_passwordHash(calcStringHash(mockPassword + salt));
	
		_users.add(user1);	
		
		////////////////
		
		User user2 = new User();
		user2.set_group(Group.Usuário);
		user2.set_allowAccessAfter(new Timestamp(System.currentTimeMillis()));
		
		scanner = null;
		try {
			scanner = new Scanner( new File("Pacote-T3/Keys/user01-x509.crt") );
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		text = scanner.useDelimiter("\\A").next();
		scanner.close(); 
		user2.set_pemCertificate(text);		
		
		salt = (String)user2.get_loginName().substring(0, 9);
		user2.set_salt(salt);
		
		mockPassword = "162534";
		user2.set_passwordHash(calcStringHash(mockPassword + salt));
	
		_users.add(user2);	
	}
	
	private byte[] calcStringHash(String string){
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-1");
			digest.update(string.getBytes());
			return digest.digest();
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean addUser(User user) {
		return _users.add(user);
	}

	@Override
	public ArrayList<User> getAllUsers() {
		return _users;
	}

	@Override
	public boolean updateUser(User user){
		for(User u : _users){
			if(user.get_loginName().equals(u.get_loginName())){
				u = user;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		for(User u : _users){
			if(user.get_loginName().equals(u.get_loginName())){
				_users.remove(user);
				return true;
			}
		}
		return false;
	}

	@Override
	public User getUserByLoginName(String loginName) {
		for(User u : _users){
			if(loginName.equals(u.get_loginName())){
				return u;
			}
		}
		return null;
	}
}
