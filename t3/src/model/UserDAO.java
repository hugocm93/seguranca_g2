package model;

public interface UserDAO {
	
	public boolean addUser(User user);
	public User getUserByLoginName(String loginName);
	public boolean updateUser(User user);
}
