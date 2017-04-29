package presenter;

import model.User;
import view.ConfirmationDialog;

public class ConfirmationPresenter implements ConfirmationPresenterListener{
	
	private ConfirmationDialog _dialog;
	private MenuPresenter _menu;

	public ConfirmationPresenter(MenuPresenter menu) {
		super();
		_menu = menu;
		
		_dialog = new ConfirmationDialog(this);
	}

	@Override
	public void OkButtonPressed() {
		User admin = _menu.get_session().get_user();
		admin.incNUsers();
		_menu.buildBody1();
		_dialog.dispose();	
	}

	public void showWindow(){
		_dialog.setVisible(true);
	}

}
