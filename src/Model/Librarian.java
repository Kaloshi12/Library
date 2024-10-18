package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Librarian extends Employee {
	

	private static final ObservableList<Librarian> librarianList = FXCollections.observableArrayList();

    private static HashMap<String, String> librarian_logIn;


    public Librarian(String name, String surname, LocalDate birthday, String phoneNumber, Double salary,
			AccessLevel level, String userId, String password) {
		super(name, surname, birthday, phoneNumber, salary, level, userId, password);
		librarian_logIn = new HashMap<String, String>();
		librarian_logIn.put("Enio", "12345678");
	}
    
    public static void addLibrarian(Librarian librarian) {
    	librarianList.add(librarian);
    }
   public static void addLibrarianLogIn(String username,String Password) {
	  librarian_logIn.put(username, Password);
   }

	public static HashMap<String, String> getLibrarian_logIn() {
        return librarian_logIn;
    }

    public void setLibrarian_logIn(HashMap<String, String> librarian_logIn) {
        Librarian.librarian_logIn = librarian_logIn;
    }

    public static ObservableList<Librarian> getLibrarianList() {
        return librarianList;
    }

    @Override
    public String toString() {
        return "Librarian [librarian_logIn=" + librarian_logIn + ", getUserId()=" + getUserId() + ", getPassword()="
                + getPassword() + ", getName()=" + getName() + ", getSurname()=" + getSurname() + ", getBirthday()="
                + getBirthday() + ", getPhoneNumber()=" + getPhoneNumber() + ", getSalary()=" + getSalary()
                + ", getLevel()=" + getLevel() + ", toString()=" + super.toString() + "]";
    }
}
