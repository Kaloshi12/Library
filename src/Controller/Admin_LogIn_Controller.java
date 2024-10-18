package Controller;

import View.AdminStage;
import View.LogIn_Admin;
import Model.Admin;
import javafx.application.Platform;
import javafx.scene.paint.Color;

public class Admin_LogIn_Controller {
    private LogIn_Admin view = new LogIn_Admin();
    private AdminStage adminStage = new AdminStage();

    public LogIn_Admin getView() {
		return view;
	}

	public void setView(LogIn_Admin view) {
		this.view = view;
	}

	public AdminStage getAdminStage() {
		return adminStage;
	}

	public void setAdminStage(AdminStage adminStage) {
		this.adminStage = adminStage;
	}

	public Admin_LogIn_Controller(LogIn_Admin view) {
        this.view = view;
        view.getLogIn().setOnAction(e -> checkLogIn());
    }

    private void checkLogIn() {
        String user = view.getUsername().getText();
        String enteredPassword = view.getPassword().getText();

        view.getAdmin();
		if (Admin.getAdmin_logIn().containsKey(user)) {
            view.getAdmin();
			String storedPassword = Admin.getAdmin_logIn().get(user);
            if (storedPassword.equals(enteredPassword)) {
                Platform.runLater(() -> adminStage.open());
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
}
