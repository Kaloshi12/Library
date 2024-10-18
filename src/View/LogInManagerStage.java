package View;

import Controller.LogInManager_Controller;
import javafx.scene.Scene;

public class LogInManagerStage extends OpenStage{
private LogIn_Manager view = new LogIn_Manager();
private LogInManager_Controller ctrl = new LogInManager_Controller(view);
	@Override
	public void open() {
		Scene scene = new Scene(view,300,280);
		view.getStage().setScene(scene);
		view.getStage().show();
		
	}
	public LogIn_Manager getView() {
		return view;
	}
	public void setView(LogIn_Manager view) {
		this.view = view;
	}
	public LogInManager_Controller getCtrl() {
		return ctrl;
	}
	public void setCtrl(LogInManager_Controller ctrl) {
		this.ctrl = ctrl;
	}

}
