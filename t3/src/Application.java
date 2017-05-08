import Util.LogView;
import Util.MessageManager;
import model.GroupDAOBDImplementation;
import model.MessageDAOBDImplementation;
import model.Register;
import model.RegisterDAOBDImplementation;
import model.UserDAOBDImplementation;
import presenter.LoginPresenter;

public class Application {
	
	public static void main(String[] args) {
		// Create BD
		GroupDAOBDImplementation.getInstance().populateDataBase();
		MessageDAOBDImplementation.getInstance();
		UserDAOBDImplementation.getInstance();
		RegisterDAOBDImplementation.getInstance();
		MessageManager.getInstance();
		
		LoginPresenter loginPresenter = new LoginPresenter();
		loginPresenter.showWindow();
		
		Register r = new Register(1001, -1, null, null);
		r.Log();
		Register r2 = new Register(2001, -1, null, null);
		r2.Log();
		
		// exemplo 1 = Id do user.. verificar no banco
		//LogView.showLog();
	}
	
}
