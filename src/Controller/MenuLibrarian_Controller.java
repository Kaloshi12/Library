package Controller;

import View.BookListView;
import View.MenuLibrarianView;
import View.SellBookStage;
import View.SoldBookStage;
import View.SoldBooksView;

public class MenuLibrarian_Controller {
    private MenuLibrarianView view = new MenuLibrarianView();
    private BookListView stage = new BookListView();
    private SellBookStage sellBook = new SellBookStage();
   private SoldBookStage soldBooks = new SoldBookStage();

    public MenuLibrarian_Controller(MenuLibrarianView view) {
        this.view = view;
        view.getShowBooks().setOnAction(e -> stage.open());
        view.getSellBook().setOnAction(e -> sellBook.open());
        view.getSoldBook().setOnAction(e -> soldBooks.show()); // Corrected action
    }

    public SellBookStage getSellBook() {
        return sellBook;
    }

    public void setSellBook(SellBookStage sellBook) {
        this.sellBook = sellBook;
    }

    public MenuLibrarianView getView() {
        return view;
    }

    public void setView(MenuLibrarianView view) {
        this.view = view;
    }

    public BookListView getStage() {
        return stage;
    }

    public void setStage(BookListView stage) {
        this.stage = stage;
    }
}
