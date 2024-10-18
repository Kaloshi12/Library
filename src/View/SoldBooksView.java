package View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Map;

import Model.Book;

public class SoldBooksView extends BorderPane {
    private Stage stage;
    private ListView<String> soldBooksListView;
    private ObservableMap<Book, Integer> soldBooksMap;

    public SoldBooksView(ObservableMap<Book, Integer> soldBooksMap) {
        stage = new Stage();
        stage.setTitle("Sold Books");

        this.soldBooksMap = FXCollections.observableMap(soldBooksMap);

        soldBooksListView = new ListView<>();
        updateSoldBooksListView();

        setCenter(soldBooksListView);
    }

    private void updateSoldBooksListView() {
        soldBooksListView.getItems().clear();
        for (Map.Entry<Book, Integer> entry : soldBooksMap.entrySet()) {
            Book book = entry.getKey();
            int quantity = entry.getValue();
            soldBooksListView.getItems().add(String.format("%s (Quantity: %d)", book.getTitle(), quantity));
        }
    }

    public void show() {
        Scene scene = new Scene(this, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
