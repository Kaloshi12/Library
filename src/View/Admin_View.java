package View;



import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Admin_View extends Pane {
	private Text text;
	private Text register;
	private Button showBooks;
	private Button addBooks;
	private Button showSoldBooks;
	private Button delete;
	private Button register_Manager;
	private Button regiser_Librarian;
	private Button check_Librarian;
	
	private Stage Astage;

		 public Admin_View(){
			Astage = new Stage();
			Astage.setTitle("Administrator");
			text = new Text();
			text.setText("Welcome Admin");
			text.setLayoutX(150);
			text.setLayoutY(50);
			text.setFont(Font.font("Arial", FontPosture.ITALIC, 50));
			register = new Text();
			register.setText("Register");
			register.setLayoutX(200);
			register.setLayoutY(180);
			register.setFont(Font.font("Arial",FontWeight.BOLD,50));
			addBooks = new Button();
			addBooks.setText("Add Book");
			addBooks.setLayoutX(20);
			addBooks.setLayoutY(400);
			addBooks.setPrefWidth(120);
			addBooks.setPrefHeight(60);
			addBooks.setOnMouseEntered(e -> addBooks.setStyle("-fx-background-color: lightblue;"));
	        addBooks.setOnMouseExited(e -> addBooks.setStyle(null));
			showBooks = new Button();
	        showBooks.setText("Books");
			showBooks.setLayoutX(160);
			showBooks.setLayoutY(400);
			showBooks.setPrefWidth(120);
			showBooks.setPrefHeight(60);
			showBooks.setOnMouseEntered(e -> showBooks.setStyle("-fx-background-color: lightblue;"));
			showBooks.setOnMouseExited(e -> showBooks.setStyle(null));
			showSoldBooks = new Button();
			showSoldBooks.setText("Sold Books");
			showSoldBooks.setLayoutX(300);
			showSoldBooks.setLayoutY(400);
			showSoldBooks.setPrefWidth(120);
			showSoldBooks.setPrefHeight(60);
			showSoldBooks.setOnMouseEntered(e -> showSoldBooks.setStyle("-fx-background-color: lightblue;"));
			showSoldBooks.setOnMouseExited(e -> showSoldBooks.setStyle(null));
			delete = new Button();
			delete.setText("Remove Book");
			delete.setLayoutX(440);
			delete.setLayoutY(400);
			delete.setPrefWidth(120);
			delete.setPrefHeight(60);
			delete.setOnMouseEntered(e -> delete.setStyle("-fx-background-color: lightblue;"));
			delete.setOnMouseExited(e -> delete.setStyle(null));
			register_Manager = new Button("Manager");
			register_Manager.setLayoutX(150);
			register_Manager.setLayoutY(200);
			register_Manager.setPrefWidth(120);
			register_Manager.setPrefHeight(60);
			register_Manager.setOnMouseEntered(e -> register_Manager.setStyle("-fx-background-color: lightblue;"));
			register_Manager.setOnMouseExited(e -> register_Manager.setStyle(null));
			regiser_Librarian = new Button("Librarian");
			regiser_Librarian.setLayoutX(310);
			regiser_Librarian.setLayoutY(200);
			regiser_Librarian.setPrefWidth(120);
			regiser_Librarian.setPrefHeight(60);
			regiser_Librarian.setOnMouseEntered(e -> regiser_Librarian.setStyle("-fx-background-color: lightblue;"));
			regiser_Librarian.setOnMouseExited(e -> regiser_Librarian.setStyle(null));
			check_Librarian = new Button("Controll");
			check_Librarian.setLayoutX(230);
			check_Librarian.setLayoutY(300);
			check_Librarian.setPrefWidth(120);
			check_Librarian.setPrefHeight(60);
			check_Librarian.setOnMouseEntered(e -> check_Librarian.setStyle("-fx-background-color: lightblue;"));
			check_Librarian.setOnMouseExited(e -> check_Librarian.setStyle(null));
			
			getChildren().addAll(text,register,addBooks,showBooks,showSoldBooks,delete,register_Manager,regiser_Librarian,check_Librarian);
			
		}


	public Text getText() {
			return text;
		}


		public void setText(Text text) {
			this.text = text;
		}


		public Button getShowBooks() {
			return showBooks;
		}


		public void setShowBooks(Button showBooks) {
			this.showBooks = showBooks;
		}


		public Button getAddBooks() {
			return addBooks;
		}


		public void setAddBooks(Button addBooks) {
			this.addBooks = addBooks;
		}


		public Button getShowBorrowedBooks() {
			return showSoldBooks;
		}


		public void setShowBorrowedBooks(Button showSoldBooks) {
			this.showSoldBooks = showSoldBooks;
		}


		public Button getDelete() {
			return delete;
		}


		public void setDelete(Button delete) {
			this.delete = delete;
		}


		public Stage getAstage() {
			return Astage;
		}


		public void setAstage(Stage Astage) {
			Astage = Astage;
		}
		public Text getRegister() {
			return register;
		}


		public void setRegister(Text register) {
			this.register = register;
		}


		public Button getShowSoldBooks() {
			return showSoldBooks;
		}


		public void setShowSoldBooks(Button showSoldBooks) {
			this.showSoldBooks = showSoldBooks;
		}


		public Button getRegister_Manager() {
			return register_Manager;
		}


		public void setRegister_Manager(Button register_Manager) {
			this.register_Manager = register_Manager;
		}


		public Button getRegiser_Librarian() {
			return regiser_Librarian;
		}


		public void setRegiser_Librarian(Button regiser_Librarian) {
			this.regiser_Librarian = regiser_Librarian;
		}


		public Button getCheck_Librarian() {
			return check_Librarian;
		}


		public void setCheck_Librarian(Button check_Librarian) {
			this.check_Librarian = check_Librarian;
		}


		


}
