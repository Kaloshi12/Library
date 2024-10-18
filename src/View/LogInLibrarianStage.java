package View;

import Controller.LogInLibrarian_Controller;
import javafx.scene.Scene;

public class LogInLibrarianStage extends OpenStage {
private LogIn_Librarian view = new LogIn_Librarian();
private LogInLibrarian_Controller ctrl = new LogInLibrarian_Controller(view);

	@Override
	public void open() {
		Scene scene = new Scene(view,300,280);
		view.getStage().setScene(scene);
		view.getStage().show();
		
	}
	public LogIn_Librarian getView() {
		return view;
	}
	public void setView(LogIn_Librarian view) {
		this.view = view;
	}
	public LogInLibrarian_Controller getCtrl() {
		return ctrl;
	}
	public void setCtrl(LogInLibrarian_Controller ctrl) {
	}
}
