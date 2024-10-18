package Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import Model.AccessLevel;
import Model.Librarian;
import Model.Manager;
import View.AddLibrarianView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AddLibrarian_Controller {
    private AddLibrarianView view = new AddLibrarianView();

    public AddLibrarian_Controller(AddLibrarianView view) {
        this.view = view;
        this.view.getAddButton().setOnAction(e -> addLibrarian());
    }

    public void addLibrarian() {
        
        

    	 String name = view.getNameField().getText();
         String surname = view.getSurnameField().getText();
         LocalDate birthday = view.getBirthdayPicker().getValue();  
         String phoneNumber = view.getPhoneNumberField().getText();
         double salary;

         try {
             salary = Double.parseDouble(view.getSalaryField().getText());
         } catch (NumberFormatException e) {
             showWrongAlert("Error", "Invalid salary format. Please enter a valid number.");
             return;
         }

         String userId = view.getUserIdField().getText();
         String password = view.getPasswordField().getText();
         if (!validInput(name, "Name") ||
                 !validInput(surname, "Surname") ||
                 !validInput(userId, "UserId") ||
                 !validInput(password, "Password")) {
                 return;
             }
         for (Librarian existingManager : Librarian.getLibrarianList()) {
             if (existingManager.getName().equals(name) && existingManager.getSurname().equals(surname)) {
                 showWrongAlert("Error", "Manager with the same name and surname already exists. Please choose a different one.");
                 return;
             }
             if (existingManager.getUserId().equals(userId)) {
                 showWrongAlert("Error", "User ID already exists. Please choose a different one.");
                 return;
             }
         }

         Librarian librarian = new Librarian(name, surname, birthday, phoneNumber, salary, AccessLevel.MANAGER, userId, password);
         Librarian.addLibrarian(librarian);
         Librarian.addLibrarianLogIn(surname, password);
         
         

         view.getLibrarianTableView().setItems(Librarian.getLibrarianList());

         clearFields();

         showSuccessAlert("Success", "Manager added successfully: " + name + surname);
    }

    public LocalDateTime parseDate(String dateString) {
        try {
            return LocalDateTime.parse(dateString);
        } catch (Exception e) {
            view.getMessageText().setText("Error parsing date. Please enter the date in the correct format.");
            return null;
        }
    }

    public void clearFields() {
        view.getNameField().clear();
        view.getSurnameField().clear();
        view.getBirthdayPicker().setValue(null);
        view.getPhoneNumberField().clear();
        view.getSalaryField().clear();
        view.getUserIdField().clear();
        view.getPasswordField().clear();
    }
    public boolean validInput(String input , String fieldName) {
  	   String regex = "\\b[a-zA-Z]+\\b[a-zA-Z]+.*";
  	   if (!input.matches(regex)) {
  	        showWrongAlert("Failed", fieldName + " must contain 2 or more words.");
  	        return false;
  	    }
  	   return true;

     }
    
    private void showSuccessAlert(String title,String message) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Success");
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    

    public void showWrongAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public AddLibrarianView getView() {
        return view;
    }

    public void setView(AddLibrarianView view) {
        this.view = view;
    }
}
