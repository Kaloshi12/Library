package Controller;

import java.util.Date;
import java.util.Random;

import Model.Bill;
import Model.Book;
import View.BillView;
import View.SellBookView;
import javafx.collections.ObservableList;

public class SellBook_Controller {
    private SellBookView view;

    public SellBook_Controller(SellBookView view) {
        this.view = view;
        view.getBuyButton().setOnAction(e -> handleBuyButton());
    }

    public void handleBuyButton() {
        ObservableList<Book> selectedBooks = view.getList().getSelectionModel().getSelectedItems();
        
       
        Random random = new Random();
        int Id = 100000 + random.nextInt(900000);
        		
        Bill bill = new Bill(Id,selectedBooks.toArray(new Book[0]), new Date(), calculateTotalPrice(selectedBooks));

      
        Bill.addBillList(bill);

       
        BillView billView = new BillView(bill);
        billView.getStageBill().show();
    }

    private double calculateTotalPrice(ObservableList<Book> books) {
        double totalPrice = 0.0;
        for (Book book : books) {
            totalPrice += book.getPrice();
        }
        return totalPrice;
    }
}
