package Controller;


import View.AddLibrarianStage;
import View.AddManager_Stage;
import View.Admin_View;
import View.Bill_IdStage;
import View.Bill_IdView;
import View.BookListView;
import View.DeleteBookStage;
import View.StageAddBook;

public class Admin_View_Controller {
	private Admin_View view = new Admin_View();
	private BookListView stage = new BookListView();
	private StageAddBook addBook = new StageAddBook();
	private AddManager_Stage addManager = new AddManager_Stage();
	private DeleteBookStage deleteStage = new DeleteBookStage();
	private AddLibrarianStage addLibrarian = new AddLibrarianStage();
	private Bill_IdStage bill = new Bill_IdStage();
	
	public Admin_View_Controller(Admin_View view) {
		
		view.getShowBooks().setOnAction(e -> stage.open());
		view.getAddBooks().setOnAction(e -> addBook.open());
		view.getRegister_Manager().setOnAction(e -> addManager.open());
		view.getDelete().setOnAction(e -> deleteStage.open());
		view.getRegiser_Librarian().setOnAction(e -> addLibrarian.open());
		view.getCheck_Librarian().setOnAction(e -> bill.open());
	}
	
	  
	
	public BookListView getStage() {
		return stage;
	}

	public void setStage(BookListView stage) {
		this.stage = stage;
	}

	public StageAddBook getAddBook() {
		return addBook;
	}

	public void setAddBook(StageAddBook addBook) {
		this.addBook = addBook;
	}

	public AddManager_Stage getAddManager() {
		return addManager;
	}

	public void setAddManager(AddManager_Stage addManager) {
		this.addManager = addManager;
	}

	

	public Admin_View getView() {
		return view;
	}

	public void setView(Admin_View view) {
		this.view = view;
	}
	
	
}
