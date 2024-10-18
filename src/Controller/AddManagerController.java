package Controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.time.LocalDate;
import Files.Files_Menager;
import Model.AccessLevel;
import Model.Manager;
import View.AddManagerView;

public class AddManagerController {
    private AddManagerView view;
    private Files_Menager file;
    public AddManagerController(AddManagerView view) {
        this.view = view;
        file = new Files_Menager();
        view.getAddButton().setOnAction(e -> addManager());
    }

    public void addManager() {
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
//        if (!validInput(name, "Name") ||
//                !validInput(surname, "Surname") ||
//                !validInput(userId, "UserId") ||
//                !validInput(password, "Password")) {
//                return;
//            }
        for (Manager existingManager : file.getAll()) {
            if (existingManager.getName().equals(name) && existingManager.getSurname().equals(surname)) {
                showWrongAlert("Error", "Manager with the same name and surname already exists. Please choose a different one.");
                return;
            }
            if (existingManager.getUserId().equals(userId)) {
                showWrongAlert("Error", "User ID already exists. Please choose a different one.");
                return;
            }
        }

        Manager manager = new Manager(name, surname, birthday, phoneNumber, salary, AccessLevel.MANAGER, userId, password);
if (file.create(manager)) {
            
        	System.out.println("Saved successfully");
            clearFields();
            
            view.getManagerTableView().setItems(file.getAll());
        } else {
            showWrongAlert("Failed", "Failed to save the manager");
        }

        

        clearFields();

        //showSuccessAlert("Success", "Manager added successfully: " + name +" "+ surname);
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
    
//    private void showSuccessAlert(String title,String message) {
//        Alert alert = new Alert(AlertType.NONE);
//        alert.setTitle("Success");
//        alert.setHeaderText(title);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }

    public void showWrongAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
