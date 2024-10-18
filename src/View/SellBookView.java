package View;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import Files.Files_Book;
import Model.Book;
import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.ListCell;
	import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
	import javafx.scene.layout.HBox;
	import javafx.scene.text.Text;
	import javafx.stage.Stage;

	public class SellBookView extends  BorderPane {
	    private Stage stageBook;
	    private final Files_Book file;
	    private ListView<Book> list;
	    private Button buyButton;
	    private Text text;

	    public SellBookView() {
	    	
	        stageBook = new Stage();
	        stageBook.setTitle("Books");
	        text = new Text();
	        text.setText("Books");
	        file = new Files_Book();
	        list = new ListView<Book>(file.loadBookFromFile());
	        list.setCellFactory(param -> new ListCell<Book>() {
	            @Override
	            protected void updateItem(Book book, boolean empty) {
	                super.updateItem(book, empty);

	                if (empty || book == null) {
	                    setText(null);
	                } else {
	                	setText(String.format("%s by %s - Pages: %d Quantity: %d Price: %.2f",
	                		    book.getTitle(), book.getAuthor(), book.getPages(), book.getQuantity(), book.getPrice()));
	                }
	            }
	        });
	        
	        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	        FlowPane pane = new FlowPane();
	        pane.getChildren().add(text);
	        setCenter(pane);
	        
	        
	        HBox hbox = new HBox();
	      
	        buyButton = new Button("Buy");
	        buyButton.setPrefWidth(120);
	        buyButton.setPrefHeight(50);
	       
	        hbox.getChildren().addAll(buyButton);
	        hbox.setSpacing(50.0);
	        setBottom(hbox);
	        setCenter(list);
	    }
	    public Stage getStageBook() {
	        return stageBook;
	    }

	    public void setStageBook(Stage stageBook) {
	        this.stageBook = stageBook;
	    }

	    public ListView<Book> getList() {
	        return list;
	    }

	    public void setList(ListView<Book> list) {
	        this.list = list;
	    }

	   
	   

		public Button getBuyButton() {
			return buyButton;
		}
		public void setBuyButton(Button buyButton) {
			this.buyButton = buyButton;
		}
		public Text getText() {
			return text;
		}

		public void setText(Text text) {
			this.text = text;
		}

}
