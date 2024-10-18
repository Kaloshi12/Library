package View;

import Controller.Admin_LogIn_Controller;
import javafx.scene.Scene;

public class viewAdminLogIn extends OpenStage {
LogIn_Admin adminView =new LogIn_Admin();
Admin_LogIn_Controller adminCont = new Admin_LogIn_Controller(adminView);
	@Override
	public void open() {
		 Scene scene = new Scene(adminView, 300, 280);
	        adminView.getStage().setScene(scene);
	       adminView.getStage().show();
		
	}

}
