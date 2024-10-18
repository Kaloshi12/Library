package View;

import Controller.MenuLibrarian_Controller;
import javafx.scene.Scene;

public class MenuLibrarianStage extends OpenStage{
private MenuLibrarianView view = new MenuLibrarianView();
private MenuLibrarian_Controller ctrl = new MenuLibrarian_Controller(view);
	public MenuLibrarianView getView() {
	return view;
}
public void setView(MenuLibrarianView view) {
	this.view = view;
}
public MenuLibrarian_Controller getCtrl() {
	return ctrl;
}
public void setCtrl(MenuLibrarian_Controller ctrl) {
	this.ctrl = ctrl;
}
	@Override
	public void open() {
		Scene scene = new Scene(view,500,600);
		view.getLstage().setScene(scene);
		view.getLstage().show();
		
	}

}
