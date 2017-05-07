package presenter;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import Util.Authentication;
import Util.StringExtension;
import model.Register;
import model.User;
import model.UserDAOBDImplementation;
import model.UserSession;
import structures.Pair;
import structures.PasswordTree;
import view.LoginWindow;

public class LoginPresenter implements LoginPresenterListener{
	
	private LoginWindow _loginWindow;
	private UserDAOBDImplementation _userDAO;
	private UserSession _session;
	
	
	public LoginPresenter() {
		super();

		_loginWindow = new LoginWindow(this);
		_userDAO = UserDAOBDImplementation.getInstance();
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
				Register r = new Register(2003, user.getId(), user.get_loginName(), null);
				r.Log();
				Register r2 = new Register(2002, -1, null, null);
				r2.Log();
				Register r3 = new Register(3001, user.getId(), user.get_loginName(), null);
				r3.Log();
			}
			else{
				double timeDifference = user.get_allowAccessAfter().getTime() - 
									    currentTime.getTime();
				timeDifference /= 1000; // em segundos
				String message = "Acesso bloqueado. Tente novamente em " + 
								 String.format("%.2f", timeDifference) + " segundos";
				
				_loginWindow._firstWarningLabel.setVisible(true);
				_loginWindow._firstWarningLabel.setText(message);
				Register r = new Register(2004, user.getId(), user.get_loginName(), null);
				r.Log();
			}
			
		}
		else{
			_loginWindow._firstWarningLabel.setVisible(true);
			_loginWindow._firstWarningLabel.setText("Identificação inválida");
			Register r = new Register(2005, -1, loginName, null);
			r.Log();
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
		String binPath = _loginWindow._binPathJTextField.getText();
		String secretPhrase = _loginWindow._secretPhraseJTextField.getText();
		
		if (binPath != null && !binPath.isEmpty() && secretPhrase != null && !secretPhrase.isEmpty()) {
			if(binPath.length() < 255 && secretPhrase.length() < 255) {
				System.out.println("Path: "+binPath);
				System.out.println("Frase secreta: "+secretPhrase);
				verifyPrivateKey(binPath, secretPhrase);
			} else {
				_loginWindow._thirdWarningLabel.setVisible(true);
				_loginWindow._thirdWarningLabel.setText("Input muito grande");
				System.out.println("Input too big");
			}
		} else {
			_loginWindow._thirdWarningLabel.setVisible(true);
			_loginWindow._thirdWarningLabel.setText("Preencher campos obrigatórios");
			System.out.println("Missing input");
		}
	}

	@Override
	public void confirmPasswordButtonPressed() {
		boolean wrongPassword = !checkPassword();
		User user = _session.get_user();
		if(wrongPassword){
			_session.get_virtualButtonsPressed().clear();
			_session.incAttempts();
			
			switch(_session.get_numberOfAttempts()) {
			case 1:
				Register r = new Register(3007, user.getId(), user.get_loginName(), null);
				r.Log();
				break;
			case 2:
				Register r2 = new Register(3008, user.getId(), user.get_loginName(), null);
				r2.Log();
				break;
			case 3:
				Register r3 = new Register(3009, user.getId(), user.get_loginName(), null);
				r3.Log();
				break;
			}

			if(_session.get_numberOfAttempts() == 3){
				user.set_allowAccessAfter(new Timestamp(System.currentTimeMillis() + 120000));
				_userDAO.updateUser(user);
				_loginWindow.login();
				Register r = new Register(3010, user.getId(), user.get_loginName(), null);
				r.Log();
				Register r2 = new Register(3002, user.getId(), user.get_loginName(), null);
				r2.Log();
				Register r3 = new Register(2001, -1, null, null);
				r3.Log();
				return;
			}
			
			_loginWindow.loginNameSucceded();
			_loginWindow._secondWarningLabel.setVisible(true);
			_loginWindow._secondWarningLabel.setText("Senha incorreta");
		}
		else{
			_loginWindow.passwordSucceded();
			Register r1 = new Register(3002, user.getId(), user.get_loginName(), null);
			r1.Log();
			Register r2 = new Register(4001, user.getId(), user.get_loginName(), null);
			r2.Log();
		}
	}
	
	private void presentMenuView() {
		_loginWindow._thirdWarningLabel.setVisible(false);
		_loginWindow._thirdWarningLabel.setText("");
		_session.get_user().incNAcesses();
		_loginWindow.getFrame().setVisible(false);
		_loginWindow.getFrame().dispose();
		MenuPresenter menuPresenter = new MenuPresenter(_session);
		menuPresenter.showWindow();
	}
	
	private void verifyPrivateKey(String pathPrivateKey, String secretText){
		String pemPrivateKey = "";
		try {
			byte[] bytePemPrivateKey = Authentication.SymmetricDecription(pathPrivateKey, secretText);
			pemPrivateKey = StringExtension.convertToUTF8(bytePemPrivateKey);
			System.out.println(pemPrivateKey);
			pemPrivateKey = pemPrivateKey.replaceAll("-----BEGIN PRIVATE KEY-----","");
			pemPrivateKey = pemPrivateKey.replaceAll("-----END PRIVATE KEY-----", "");
			pemPrivateKey = pemPrivateKey.replaceAll("\\s", "");
			
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException | IOException e) {
			_loginWindow._thirdWarningLabel.setVisible(true);
			_loginWindow._thirdWarningLabel.setText("Falha na autenticação do usuário");
			System.out.println("Private key error");
			loginFail();
			
			return;
		}
		
		boolean isSigned = false;
		try {
			isSigned = Authentication.verifyPrivateKeySignature(
					Authentication.getPrivateKey(pemPrivateKey), 
					_session.get_user().getCertificate());
		} catch (Exception e) {
			_loginWindow._thirdWarningLabel.setVisible(true);
			_loginWindow._thirdWarningLabel.setText("Falha na autenticação do usuário");
			System.out.println(e);
			loginFail();
			
			return;
		}
		
		if(isSigned) {
			User user = _session.get_user();
			if(user.getPrivateKeyBase64() == null)
			{
				user.setPrivateKeyBase64(pemPrivateKey);
				_userDAO.updateUser(user);
			}
			presentMenuView();
		} else {
			_loginWindow._thirdWarningLabel.setVisible(true);
			_loginWindow._thirdWarningLabel.setText("Falha na autenticação do usuário");
			System.out.println("User Authentication Error");
			loginFail();
			
			return;
		}
	}
	
	private void loginFail() {
		if(_session.get_numberOfAuthAttempts() >= 2){
			_session.incAuthAttempts();
			User user = _session.get_user();
			user.set_allowAccessAfter(new Timestamp(System.currentTimeMillis() + 120000));
			_userDAO.updateUser(user);
			_loginWindow.login();	
		}
		_session.incAuthAttempts();
		
		return;
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
		byte[] hash1 = Authentication.calcStringHash(auxString + _session.get_user().get_salt());
		byte[] hash2 = _session.get_user().get_passwordHash();
		return Authentication.compareHash(hash1, hash2);
	}
	
}
