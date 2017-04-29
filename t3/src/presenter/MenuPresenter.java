package presenter;

import model.UserSession;
import view.MenuWindow;

public class MenuPresenter implements MenuPresenterListener{
	
	private MenuWindow _menuWindow;
	private UserSession _session;

	public MenuPresenter(UserSession session) {
		super();
		
		_menuWindow = new MenuWindow(this);
		_session = session;
	}
	
	public void showWindow(){
		buildHeader();
		
		_menuWindow.show();
	}
	
	public void buildHeader(){
		String login = _session.get_user().get_loginName();
		String name = _session.get_user().getUserName();
		String group = _session.get_user().get_group().getGroupName();
		
		_menuWindow._loginLabel.setText(login);
		_menuWindow._nomeLabel.setText(name);
		_menuWindow._grupoLabel.setText(group);
	}

}
