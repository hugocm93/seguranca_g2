package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Util.MessageManager;

public class Register {
	private int registerId;
	private int messageId;
	private int userId;
	private String loginName;
	private String message;
	private String timeRegister;
	private String filename;
	
	public Register(int messageId, int userId, String loginName, String filename) {
		String message = MessageManager.getInstance().getMessage(messageId);

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		this.timeRegister = dateFormat.format(date).toString();
		this.loginName = loginName;
		this.messageId = messageId;
		this.userId = userId;
		this.filename = filename;
		
		if(message != null) {
			this.message = message;
		} else {
			this.message = "error";
		}
	}
	
	public void Log() {
		System.out.println(getMessageComplete());
		RegisterDAOBDImplementation.getInstance().insertOnBD(this);
	}
	
	public String getMessageComplete() {
		String login = this.loginName;
		String filename = this.filename;
		if(login == null) {
			login = "error on fetch loginName";
		}
		if(filename == null) {
			filename = "error on fetch fileName";
		}
		String complete = this.timeRegister + " - ";
		complete = complete.concat(message.replace("<arq_name>", filename).replace("<login_name>", login));
		
		
		String result = complete;
		return result;
	}

	public int getRegisterId() {
		return registerId;
	}

	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTimeRegister() {
		return timeRegister;
	}

	public void setTimeRegister(String timeRegister) {
		this.timeRegister = timeRegister;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

}
