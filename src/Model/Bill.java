package Model;

import java.util.Arrays;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Bill {
    private int billID;
	private Book[] book; 
    private Date date;
    private double totalPrice;
    private static ObservableList<Bill> billList = FXCollections.observableArrayList();

    

    public Bill(int billId,Book[] book, Date date,double totalPrice) {
        this.billID = billId;
    	this.book = book;
        this.date = date;
        this.totalPrice = totalPrice;
    }



	@Override
	public String toString() {
		return "Bill [book=" + Arrays.toString(book) + ", date=" + date + ", totalPrice=" + totalPrice + "]";
	}



	public Book[] getBook() {
		return book;
	}



	public void setBook(Book[] book) {
		this.book = book;
	}



	public double getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}



	public static void setBillList(ObservableList<Bill> billList) {
		Bill.billList = billList;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}

	public int getBillID() {
		return billID;
	}



	public void setBillID(int billID) {
		this.billID = billID;
	}



	public static ObservableList<Bill> getBillList(){
		return billList;
	}
	public static void addBillList(Bill bill) {
		billList.add(bill);
	}


}
