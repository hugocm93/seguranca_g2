package model;

import java.util.ArrayList;

import structures.Pair;

public class UserSession {
	
	private User _user = null;
	private int _numberOfAttempts = 0;
	private int _numberOfAuthAttempts = 0;
	
	private ArrayList<Pair<String, String>> _virtualButtonsPressed;
	
	public UserSession(User user){
		super();

		_user = user;
		_virtualButtonsPressed = new ArrayList<Pair<String, String>>();
	}
	
	public User get_user() {
		return _user;
	}
	
	public void set_user(User _user) {
		this._user = _user;
	}
	
	public int get_numberOfAttempts() {
		return _numberOfAttempts;
	}
	
	public int get_numberOfAuthAttempts() {
		return _numberOfAuthAttempts;
	}
	
	public void incAttempts() {
		++(this._numberOfAttempts);
	}
	
	public void incAuthAttempts() {
		++(this._numberOfAuthAttempts);
	}

	public ArrayList<Pair<String, String>> get_virtualButtonsPressed() {
		return _virtualButtonsPressed;
	}

	public void set_virtualButtonsPressed(ArrayList<Pair<String, String>> _virtualButtonsPressed) {
		this._virtualButtonsPressed = _virtualButtonsPressed;
	}
	
}
