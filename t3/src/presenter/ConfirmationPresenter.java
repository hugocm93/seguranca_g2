package presenter;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.swing.JOptionPane;

import model.Register;
import model.User;
import model.UserDAOBDImplementation;
import view.ConfirmationDialog;

public class ConfirmationPresenter implements ConfirmationPresenterListener{
	
	private ConfirmationDialog _dialog;
	private MenuPresenter _menu;
	private User _newUser;
	private User _user;

	public ConfirmationPresenter(MenuPresenter menu, User user) {
		super();
		_menu = menu;
		_user = user;
		
		_dialog = new ConfirmationDialog(this);
		initialize();
	}

	private void initialize() {
		X509Certificate certificate = null;
		_newUser= _menu.createUser();
		try {
			certificate = _newUser.getCertificate();
		} catch (CertificateException e) {
			JOptionPane.showMessageDialog(_dialog, "Erro ao obter certificado");
		}
		
		String certificateText;
		certificateText = "Versão: " + certificate.getVersion() + "\n\n";
		certificateText += "Série: "+ certificate.getSerialNumber() + "\n\n";
		certificateText += "Validade: "+ certificate.getNotAfter().toString() + "\n\n";
		certificateText += "Tipo de assinatura: "+ certificate.getSigAlgName() + "\n\n";
		certificateText += "Emissor: "+ _newUser.getIssuer() + "\n\n";
		certificateText += "Sujeito: "+ _newUser.getSubject() + "\n\n";
		certificateText += "Email: "+ _newUser.get_loginName() + "\n\n";
		_dialog._certificateArea.setText(certificateText);
	}

	@Override
	public void OkButtonPressed() {	
		UserDAOBDImplementation userDAO = UserDAOBDImplementation.getInstance();
		if(userDAO.addUser(_newUser)){
			User admin = _menu.get_session().get_user();
			admin.incNUsers();
			Register r = new Register(6005, _user.getId(), _user.get_loginName(), null);
			r.Log();
			_menu.buildBody1();
			_menu.resetWindow();
		}
		else
		{
			JOptionPane.showMessageDialog(_dialog, "Erro. Login já está sendo usado");
		}

		_dialog.dispose();
		
	}

	public void showWindow(){
		_dialog.setVisible(true);
	}

	@Override
	public void CancelButtonPressed() {
		Register r2 = new Register(6006, _user.getId(), _user.get_loginName(), null);
		r2.Log();
		_dialog.dispose();
	}

}
