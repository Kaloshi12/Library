package View;

import Controller.Description_Controll;
import javafx.scene.Scene;

public class BookListView extends OpenStage {
private ShowAllBooks view = new ShowAllBooks();
Description_Controll ctrl = new Description_Controll(view);
	@Override
	public void open() {
		Scene scene = new Scene(view,700,700);
		view.getStageBook().setScene(scene);
		view.getStageBook().show();
	}

}
