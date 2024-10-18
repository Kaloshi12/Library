package View;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

import Model.AccessLevel;
import Model.Admin;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LogIn_Admin extends Pane{
	private Admin admin;
	private Stage stage ;
	private Label Ausername;
	private Label Apassword;
	private TextField username;
	private PasswordField password;
	private CheckBox  showPasswordCheckbox;
	private Label show ;
	private Button logIn;
	private Button back;
	private Text succes ;
	
	public LogIn_Admin() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
		LocalDate date = LocalDate.parse("98-08-09", formatter);
	    

	    admin = new Admin("Franko", "Kaloshi", date, "+355688459875", 5000.0,
	                     AccessLevel.ADMINISTRATOR,"Franko98","12345678");
	    
		
		this.stage = new Stage();
		stage.setTitle("Administrator LogIn");
		Ausername = new Label("UserID");
		Ausername.setLayoutX(20);
		Ausername.setLayoutY(55);
		Ausername.setFont(Font.font("Arial",14));
		Apassword = new Label("Password");
		Apassword.setLayoutX(20);
		Apassword.setLayoutY(100);
		Apassword.setFont(Font.font("Arial",14));
		username = new TextField();
		username.setLayoutX(120);
		username.setLayoutY(50);
		username.setFont(new Font("Arial",14));
		password = new PasswordField();
        password.setLayoutX(120);
        password.setLayoutY(100);
        password.setFont(Font.font("Arial", 14));
        show = new Label();
        show.setLayoutX(120);
        show.setLayoutY(150);
        show.setFont(Font.font("Arial",14));
        showPasswordCheckbox = new CheckBox("Show Password");
        showPasswordCheckbox.setLayoutX(120);
        showPasswordCheckbox.setLayoutY(180);
        showPasswordCheckbox.setOnAction(e -> {
        	 if (showPasswordCheckbox.isSelected()) {
        	        
        	        show.setText("Password: " + password.getText());
        	    } else {
        	       
        	        show.setText("");
        	    }
        });
        succes = new Text("");
        succes.setLayoutX(120);
        succes.setLayoutY(20);
        show.setFont(Font.font("Arial",15));
        
        logIn = new Button("Log In");
        logIn.setLayoutX(120);
        logIn.setLayoutY(220);
        

        back = new Button("Back");
        back.setLayoutX(10);
        back.setLayoutY(10);
        getChildren().addAll(Ausername, Apassword, username, password, showPasswordCheckbox, logIn, back,show,succes);
    
}	
	
	
	
	


	public Admin getAdmin() {
		return admin;
	}






	public void setAdmin(Admin admin) {
		this.admin = admin;
	}






	public void setApassword(Label apassword) {
		Apassword = apassword;
	}






	public Label getShow() {
		return show;
	}

	public void setShow(Label show) {
		this.show = show;
	}

	public Text getSucces() {
		return succes;
	}

	public void setSucces(Text succes) {
		this.succes = succes;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Label getAusername() {
		return Ausername;
	}

	public void setAusername(Label Ausername) {
		this.Ausername = Ausername;
	}

	public Label getApassword() {
		return Apassword;
	}

	public void setapassword(Label Apassword) {
		this.Apassword = Apassword;
	}

	public TextField getUsername() {
		return username;
	}

	public void setUsername(TextField username) {
		this.username = username;
	}

	public PasswordField getPassword() {
		return password;
	}

	public void setPassword(PasswordField password) {
		this.password = password;
	}

	public CheckBox getShowPasswordCheckbox() {
		return showPasswordCheckbox;
	}

	public void setShowPasswordCheckbox(CheckBox showPasswordCheckbox) {
		this.showPasswordCheckbox = showPasswordCheckbox;
	}

	public Button getLogIn() {
		return logIn;
	}

	public void setLogIn(Button logIn) {
		this.logIn = logIn;
	}

	public Button getBack() {
		return back;
	}

	public void setBack(Button back) {
		this.back = back;
	}

	


}
