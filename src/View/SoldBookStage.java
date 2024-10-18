package View;

import javafx.collections.ObservableMap;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Files.Files_Book;
import Model.Book;

public class SoldBookStage extends BorderPane {
    private Stage stage;
    private ListView<String> soldBooksListView;
    private Files_Book file;
    private ObservableMap<Book, Integer> soldBooksMap;

    public SoldBookStage() {
        stage = new Stage();
        stage.setTitle("Sold Books");
        file = new Files_Book();
        
        this.soldBooksMap = file.getSoldBooksMap();

        soldBooksListView = new ListView<>();
        updateSoldBooksListView();

        setCenter(soldBooksListView);
    }

    private void updateSoldBooksListView() {
        soldBooksListView.getItems().clear();
        for (Book book : soldBooksMap.keySet()) {
            int quantity = soldBooksMap.get(book);
            soldBooksListView.getItems().add(String.format("%s by %s - Quantity: %d",
                    book.getTitle(), book.getAuthor(), quantity));
        }
    }


    public void show() {
        Scene scene = new Scene(this, 600, 500);
        stage.setScene(scene);
        stage.show();
    }

 
    public ObservableMap<Book, Integer> getSoldBooksMap() {
        return soldBooksMap;
    }
}

