package Controller;

import Model.Librarian;
import Model.Manager;
import View.LogIn_Librarian;
import View.LogIn_Manager;
import View.MenuLibrarianStage;
import View.MenuManagerStage;
import javafx.application.Platform;
import javafx.scene.paint.Color;

public class LogInLibrarian_Controller {
private LogIn_Librarian view = new LogIn_Librarian();
private MenuLibrarianStage menuLibrarian = new  MenuLibrarianStage();


public LogInLibrarian_Controller(LogIn_Librarian view) {
	this.view = view;
	this.view.getBack().setOnAction(e -> back());
	this.view.getLogIn().setOnAction(e ->checkLogIn());
}


private void checkLogIn() {
    String user = view.getUsername().getText();
    String enteredPassword = view.getPassword().getText();
    view.getLibrarian();
	if (Librarian.getLibrarian_logIn().containsKey(user)) {
        view.getLibrarian();
		String storedPassword = Librarian.getLibrarian_logIn().get(user);
        if (storedPassword.equals(enteredPassword)) {
            Platform.runLater(() -> menuLibrarian.open() );
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
public void back() {
	view.getStage().close();
}


public LogIn_Librarian getView() {
	return view;
}


public void setView(LogIn_Librarian view) {
	this.view = view;
}


public MenuLibrarianStage getMenuLibrarian() {
	return menuLibrarian;
}


public void setMenuLibrarian(MenuLibrarianStage menuLibrarian) {
	this.menuLibrarian = menuLibrarian;
}


}
