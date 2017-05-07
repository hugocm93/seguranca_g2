package model;

public class Message {
	public int id;
	public String message;
	
	public Message(int id, String message) {
		this.id = id;
		this.message = message;
		MessageDAOBDImplementation.getInstance().insertOnBD(id, message);
	}
	
}
