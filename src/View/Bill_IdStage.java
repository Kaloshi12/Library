package View;

import javafx.scene.Scene;

public class Bill_IdStage extends OpenStage {
private Bill_IdView view = new Bill_IdView();
	@Override
	public void open() {
	Scene scene = new Scene(view,400,600);
	view.getStage().setScene(scene);
	view.getStage().show();
	}

}
