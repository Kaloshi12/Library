package Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	private StringProperty name ;
	private StringProperty surname;
	private LocalDate birthday;
	private StringProperty phoneNumber;
	private DoubleProperty salary;
	protected AccessLevel level;
	private StringProperty userId;
	private StringProperty password;
	
	
	 private void writeObject(ObjectOutputStream out) throws IOException {
	        out.defaultWriteObject();
	        out.writeObject(name.get());
	        out.writeObject(surname.get());
	        out.writeObject(birthday);
	        out.writeObject(phoneNumber.get());
	        out.writeDouble(salary.get());
	        out.writeObject(level);
	        out.writeObject(userId.get());
	        out.writeObject(password.get());
	    }
	 private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
	        in.defaultReadObject();
	        name = new SimpleStringProperty((String) in.readObject());
	        surname = new SimpleStringProperty((String) in.readObject());
	        birthday = (LocalDate) in.readObject();
	        phoneNumber = new SimpleStringProperty((String) in.readObject());
	        salary = new SimpleDoubleProperty(in.readDouble());
	        level = (AccessLevel) in.readObject();
	        userId = new SimpleStringProperty((String) in.readObject());
	        password = new SimpleStringProperty((String) in.readObject());
	    }
	
	
	public String getUserId() {
		return (String)userId.get();
	}
	public void setUserId(String userId) {
		this.userId.set(userId);;
	}
	public String getPassword() {
		return password.get();
	}
	public void setPassword(String password) {
		this.password.set(password);;
	}
	public String getName() {
		return (String)name.get();
	}
	public void setName(String name) {
		this.name.set(name);;
	}
	public String getSurname() {
		return (String)surname.get();
	}
	public void setSurname(String surname) {
		this.surname.set(surname);;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getPhoneNumber() {
		return (String)phoneNumber.get();
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.set(phoneNumber);;
	}
	public Double getSalary() {
		return salary.get();
	}
	public void setSalary(Double salary) {
		this.salary.set(salary);;
	}
	public AccessLevel getLevel() {
		return level;
	}
	public void setLevel(AccessLevel level) {
		this.level = level;
	}
	public Employee(String name, String surname, LocalDate birthday, String phoneNumber, Double salary, AccessLevel level,
			String userId, String password) {
		super();
		this.name = new SimpleStringProperty(name);
		this.surname = new SimpleStringProperty(surname);
		this.birthday = birthday;
		this.phoneNumber = new SimpleStringProperty(phoneNumber);
		this.salary = new SimpleDoubleProperty(salary);
		this.level = level;
		this.userId = new SimpleStringProperty(userId);
		this.password = new SimpleStringProperty(password);
	}
	
	

}
