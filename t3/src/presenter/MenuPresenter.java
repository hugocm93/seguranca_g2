package presenter;

import model.Group;
import model.User;
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
		buildBody1();
		buildBody2();
		_menuWindow.show();
	}
	
	public UserSession get_session() {
		return _session;
	}
	
	public void buildHeader(){
		String login = _session.get_user().get_loginName();
		String name = _session.get_user().getUserName();
		String group = _session.get_user().get_group().getGroupName();
		
		_menuWindow._loginLabel.setText(login);
		_menuWindow._nomeLabel.setText(name);
		_menuWindow._grupoLabel.setText(group);
	}
	
	public void buildBody1(){
		User user = _session.get_user();
		_menuWindow._queriesLabel.setText("" + user.getTotalQueries());
		_menuWindow._acessesLabel.setText("" + user.getTotalAcesses());
		_menuWindow._usersLabel.setText("" + user.getTotalUsers());
		_menuWindow._listingsLabel.setText("" + user.getTotalListings());
	}
	
	private void buildBody2() {
		Group group = _session.get_user().get_group();
		boolean hasPermissionToAdd = group == Group.Administrador ? true : false;
		
		_menuWindow._addUserMenuJButton.setVisible(hasPermissionToAdd);
		_menuWindow._addUserMenuJButton.setEnabled(hasPermissionToAdd);
	}

	@Override
	public void addButtonPressed() {
		ConfirmationPresenter confirmationPresenter = new ConfirmationPresenter(this);
		confirmationPresenter.showWindow();
	}

	@Override
	public void listButtonPressed() {
		User user = _session.get_user();
		user.incNQueries();	
		buildBody1();
	}

	@Override
	public void certificateListButtonPressed() {
		User user = _session.get_user();
		user.incNListings();
		buildBody1();
	}

}
