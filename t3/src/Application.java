//import java.sql.SQLException;
//import java.sql.Statement;
//
//import database.MySQLConnection;
import presenter.LoginPresenter;

public class Application {
	
	public static void main(String[] args) {
		LoginPresenter loginPresenter = new LoginPresenter();
		loginPresenter.showWindow();
		
//		Statement stmt = null;
//		try {
//			stmt = MySQLConnection.getMySQLConnection().createStatement();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	     
//      System.out.println(MySQLConnection.statusConnection());
	}
}
