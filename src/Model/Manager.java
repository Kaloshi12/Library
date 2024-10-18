package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Manager extends Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
	public Manager(String name, String surname, LocalDate birthday, String phoneNumber, Double salary,
			AccessLevel level, String userId, String password) {
		super(name, surname, birthday, phoneNumber, salary, level, userId, password);

	}
	
}
