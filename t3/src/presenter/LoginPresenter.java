package presenter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;

import model.User;
import model.UserDAOMockImplementation;
import model.UserSession;
import structures.Pair;
import structures.PasswordTree;
import view.LoginWindow;

public class LoginPresenter implements LoginPresenterListener{
	
	private LoginWindow _loginWindow;
	private UserDAOMockImplementation _userDAO;
	private UserSession _session;
	
	
	public LoginPresenter() {
		super();

		_loginWindow = new LoginWindow(this);
		_userDAO = new UserDAOMockImplementation();
	}
	
	public void showWindow(){
		_loginWindow.show();
	}

	@Override
	public void loginButtonPressed() {
		String loginName = _loginWindow._loginNameTextField.getText();
		User user = _userDAO.getUserByLoginName(loginName);
		
		if(user != null){
			Timestamp currentTime = new Timestamp(System.currentTimeMillis());
			if(currentTime.after(user.get_allowAccessAfter())){
				_session = new UserSession(user);
				randomButtons();
				_loginWindow.loginNameSucceded();
			}
			else{
				double timeDifference = user.get_allowAccessAfter().getTime() - 
									    currentTime.getTime();
				timeDifference /= 1000; // em segundos
				String message = "Acesso bloqueado. Tente novamente em " + 
								 String.format("%.2f", timeDifference) + " segundos";
				
				_loginWindow._firstWarningLabel.setVisible(true);
				_loginWindow._firstWarningLabel.setText(message);
			}
			
		}
		else{
			_loginWindow._firstWarningLabel.setVisible(true);
			_loginWindow._firstWarningLabel.setText("Identificação inválida");
		}
	}

	@Override
	public void passwordButtonPressed(String buttonName){
		String[] parts = buttonName.split("-");
		Pair<String, String> newPair = new Pair<String, String>();
		newPair.first = parts[0];
		newPair.second = parts[1];
		_session.get_virtualButtonsPressed().add(newPair);
		
		String dummyLabel = _loginWindow._passwordDummyLabel.getText();
		_loginWindow._passwordDummyLabel.setText(dummyLabel + "*");
		
		if(_session.get_virtualButtonsPressed().size() == 6)
		{
			_loginWindow._confirmButton.setEnabled(true);
		}
		else if(_session.get_virtualButtonsPressed().size() == 8)
		{
			_loginWindow.enableVirtualButtons(false);
			return;
		}
		
		randomButtons();
	}

	@Override
	public void authenticateButtonPressed() {
		_loginWindow.getFrame().setVisible(false);
		_loginWindow.getFrame().dispose();
				
		_session.get_user().incNAcesses();
		
		MenuPresenter menuPresenter = new MenuPresenter(_session);
		menuPresenter.showWindow();
	}

	@Override
	public void confirmPasswordButtonPressed() {
		boolean wrongPassword = !checkPassword();
		if(wrongPassword){
			_session.get_virtualButtonsPressed().clear();
			_session.incAttempts();
			
			if(_session.get_numberOfAttempts() == 3){
				User user = _session.get_user();
				user.set_allowAccessAfter(new Timestamp(System.currentTimeMillis() + 120000));
				_userDAO.updateUser(user);
				_loginWindow.login();
				return;
			}
			
			_loginWindow.loginNameSucceded();
			_loginWindow._secondWarningLabel.setVisible(true);
			_loginWindow._secondWarningLabel.setText("Senha incorreta");
		}
		else{
			_loginWindow.passwordSucceded();
		}
	}
	
	private void randomButtons(){
		ArrayList<String> numbers = new ArrayList<String>();
		numbers.add("0"); numbers.add("1"); numbers.add("2");
		numbers.add("3"); numbers.add("4"); numbers.add("5");
		numbers.add("6"); numbers.add("7"); numbers.add("8");
		numbers.add("9");
		
		ArrayList<Pair<String, String>> buttons = 
							new ArrayList<Pair<String, String>>();
		
		for(int i = 0; i < 5; i++){
			int randomNum1 = (int)(Math.random() * numbers.size()); 
			int randomNum2 = randomNum1;
			while(randomNum1 == randomNum2){
				randomNum2 = (int)(Math.random() * numbers.size());
			}
			Pair<String, String> newPair = new Pair<String, String>();
			newPair.first = numbers.get(randomNum1);
			newPair.second = numbers.get(randomNum2);
			
			numbers.remove(newPair.first);
			numbers.remove(newPair.second);
			buttons.add(newPair);
		}
		
		_loginWindow.populatePasswordButtons(buttons);
	}

	private boolean checkPassword(){
		PasswordTree tree = new PasswordTree(this);
		tree.populate(_session.get_virtualButtonsPressed());
		
		return tree.passwordDepthSearch();
	}

	public boolean validatePassword(String auxString) {
		byte[] hash1 = calcStringHash(auxString + _session.get_user().get_salt());
		byte[] hash2 = _session.get_user().get_passwordHash();
		return compareHash(hash1, hash2);
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

	private boolean compareHash(byte[] byte1, byte[] byte2){
		try {
			MessageDigest.getInstance("SHA-1");
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return MessageDigest.isEqual(byte1, byte2);
	}
	
}
