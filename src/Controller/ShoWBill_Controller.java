package Controller;

import Model.Bill;
import View.BillView;
import View.Bill_IdView;
import javafx.collections.ObservableList;

public class ShoWBill_Controller {
private Bill_IdView view = new Bill_IdView();



public ShoWBill_Controller(Bill_IdView view) {
	this.view = view;
	view.getShowDetailsButton().setOnAction(e -> getBillDetail());
}

public void getBillDetail() {
	ObservableList<Bill> bill = Bill.getBillList();
	int getId = view.getBillIdListView().getSelectionModel().getSelectedItem();
	for (Bill billselected : bill) {
		if(getId == billselected.getBillID()) {
			BillView billview = new BillView(billselected);
			billview.getStageBill().show();
		}
	}
}

public Bill_IdView getView() {
	return view;
}

public void setView(Bill_IdView view) {
	this.view = view;
}

}
