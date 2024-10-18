package View;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

import Model.AccessLevel;
import Model.Admin;
import Model.Librarian;
import Model.Manager;
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

public class LogIn_Librarian extends Pane{
	 
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
	LocalDate date = LocalDate.parse("98-08-09", formatter);
	private Librarian librarian = new Librarian("Enio", "Bica", date, "+355688459875", 5000.0,
             AccessLevel.LIBRARIAN,"Enio","12345678");

	public DateTimeFormatter getFormatter() {
		return formatter;
	}

	public void setFormatter(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Librarian getLibrarian() {
		return librarian;
	}

	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}

	private Stage stage ;
	private Label Lusername;
	private Label Lpassword;
	private TextField username;
	private PasswordField password;
	private CheckBox  showPasswordCheckbox;
	private Label show ;
	private Button logIn;
	private Button back;
	private Text succes ;
	
	public LogIn_Librarian() {

		this.stage = new Stage();
		stage.setTitle("Librarian LogIn");
		Lusername = new Label("UserID");
		Lusername.setLayoutX(20);
		Lusername.setLayoutY(55);
		Lusername.setFont(Font.font("Arial",14));
		Lpassword = new Label("Password");
		Lpassword.setLayoutX(20);
		Lpassword.setLayoutY(100);
		Lpassword.setFont(Font.font("Arial",14));
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
        getChildren().addAll(Lusername, Lpassword, username, password, showPasswordCheckbox, logIn, back,show,succes);
    
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

	

	public Label getLusername() {
		return Lusername;
	}

	public void setLusername(Label lusername) {
		Lusername = lusername;
	}

	public Label getLpassword() {
		return Lpassword;
	}

	public void setLpassword(Label lpassword) {
		Lpassword = lpassword;
	}

	
	


}
