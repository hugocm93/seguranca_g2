package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class UserDAOMockImplementation implements UserDAO{
	
	ArrayList<User> _users = new ArrayList<User>();
	
	public UserDAOMockImplementation(){
		User user1 = new User();
		user1.set_group(Group.Administrador);
		user1.set_loginName("admin@inf1416.puc-rio.br");
		user1.set_allowAccessAfter(new Timestamp(System.currentTimeMillis()));
		
		String salt = (String)user1.get_loginName().substring(0, 9);
		user1.set_salt(salt);
		
		String mockPassword = "162534";
		user1.set_passwordHash(calcStringHash(mockPassword + salt));
		_users.add(user1);	
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
