package Controller;

import Files.Files_Book;
import Model.Book;
import View.DeleteBooks;
import javafx.collections.ObservableList;

public class DeleteBook_Controller {
    private DeleteBooks view = new DeleteBooks();
    private final Files_Book file;

    public DeleteBook_Controller(DeleteBooks view){
        file = new Files_Book();
    	view.getDelete().setOnAction(e -> deleteBook());
    }

    private void deleteBook() {
    	 
		ObservableList<Book> selectedBook= (ObservableList<Book>) view.getList().getSelectionModel().getSelectedItems();
       for (Book book : selectedBook) {
    	   if(book.getQuantity()>1) {
    		   book.setQuantity(book.getQuantity()-1);
    	   }else {
    		   if(file.deleteAll(selectedBook)) {
    			   System.out.println("Removed");
    		   }
    	   }
	}
    
    }
}

