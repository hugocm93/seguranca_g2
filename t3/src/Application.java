import model.GroupDAOBDImplementation;
import model.MessageDAOBDImplementation;
import model.RegisterDAOBDImplementation;
import model.UserDAOBDImplementation;
import presenter.LoginPresenter;

public class Application {
	
	public static void main(String[] args) {
		// Create BD
		GroupDAOBDImplementation.getInstance().populateDataBase();
		MessageDAOBDImplementation.getInstance().populateDataBase();
		UserDAOBDImplementation.getInstance();
		RegisterDAOBDImplementation.getInstance();
		
		LoginPresenter loginPresenter = new LoginPresenter();
		loginPresenter.showWindow();
	}
	
}
