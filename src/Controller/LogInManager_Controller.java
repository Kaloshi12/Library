package Controller;

import Files.Files_Menager;
import View.LogIn_Manager;
import View.MenuManagerStage;
import javafx.application.Platform;
import javafx.scene.paint.Color;

public class LogInManager_Controller {
private LogIn_Manager view = new LogIn_Manager();
private MenuManagerStage menuManager = new  MenuManagerStage();
private Files_Menager file;

public LogInManager_Controller(LogIn_Manager view) {
	this.view = view;
	this.view.getBack().setOnAction(e -> back());
	this.view.getLogIn().setOnAction(e ->checkLogIn());
}


private void checkLogIn() {
    String user = view.getUsername().getText();
    String enteredPassword = view.getPassword().getText();
    view.getManager();
	if (file.getMan_LogIn().containsKey(user)) {
        view.getManager();
		String storedPassword = file.getMan_LogIn().get(user);
        if (storedPassword.equals(enteredPassword)) {
            Platform.runLater(() -> menuManager.open() );
        } else {
            Platform.runLater(() -> {
            	view.getSucces().setFill(Color.RED);
                view.getSucces().setText("Wrong Password!");
            });
        }
    } else {
        Platform.runLater(() -> {
            view.getSucces().setFill(Color.RED);
            view.getSucces().setText("Wrong UserID!");
        });
    }
}
public Files_Menager getFile() {
	return file;
}


public void setFile(Files_Menager file) {
	this.file = file;
}


public void back() {
	view.getStage().close();
}

public LogIn_Manager getView() {
	return view;
}

public void setView(LogIn_Manager view) {
	this.view = view;
}
public MenuManagerStage getMenuManager() {
	return menuManager;
}


public void setMenuManager(MenuManagerStage menuManager) {
	this.menuManager = menuManager;
}
}
