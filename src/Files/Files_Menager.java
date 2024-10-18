package Files;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import Model.AccessLevel;

import Model.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Files_Menager {
	public static final String FILE_PATH = "Manager.dat";
    private static final File DATA_FILE = new File(FILE_PATH);
    private ObservableList<Manager> managerList = FXCollections.observableArrayList();
    private  HashMap<String,String> man_LogIn = new HashMap<>();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
    static LocalDate date = LocalDate.parse("98-08-09", formatter);
	


    public  void addManLogIn(String userId,String password) {
    	man_LogIn.put(userId, password);
    }
    


    public ObservableList<Manager> getListbook() {
		return managerList;
	}


	public void setListbook(ObservableList<Manager> managerList) {
		this.managerList= managerList;
	}


	

	public static String getFilePath() {
		return FILE_PATH;
	}


	public static File getDataFile() {
		return DATA_FILE;
	}
	public HashMap<String,String> getMan_LogIn(){
		loadManagerFromFile();
		for (Manager manager : managerList ) {
			man_LogIn.put(manager.getUserId(),manager.getPassword());
			System.out.println(manager + "added on managerLogIn");
		}
		return man_LogIn;
	}
	
	 public ObservableList<Manager> getAll() {
	        loadManagerFromFile();
	        for (Manager manager : managerList ) {
				System.out.println(manager);
			}
	        return managerList;
	    }

	public void loadManagerFromFile() {
	    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
	        System.out.println("Reading books from file...");
	        while (inputStream.available() > 0) {
	            Manager manager = (Manager) inputStream.readObject();
	            System.out.println(manager);
	            managerList.add(manager);
	        }
	        System.out.println("Reading complete.");
	    } catch (EOFException e) {
	        System.out.println("End of file reached.");
	    } catch (IOException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	    }
	}

	public boolean create(Manager manager) {
	    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE, true))) {
	        outputStream.writeObject(manager);
	        managerList.add(manager);
	        return true;
	    } catch(IOException ex) {
	        return false;
	    }
	}


  
	public static void seedData() {
        File file = new File(Files_Book.FILE_PATH);
        if (file.length() == 0) {
        	

            Manager[] managers = {
                   new Manager("Herion","Halilaj",date,"+355688296261",2000.00,AccessLevel.MANAGER,"Herion","12345678")
            };
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
                for (Manager manager: managers ) {
                    outputStream.writeObject(manager);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @SuppressWarnings("unlikely-arg-type")
    public boolean delete(Manager manager) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            for (Manager m : managerList) {
                if (!m.equals(managerList))
                    outputStream.writeObject(m);
            }
            managerList.remove(manager);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    @SuppressWarnings("unlikely-arg-type")
    public boolean deleteAll(List<Manager> managerToRemove) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            for (Manager m : managerList) {
                if (!managerToRemove.contains(managerList))
                    outputStream.writeObject(m);
            }
            managerList.removeAll(managerToRemove);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public boolean updateAll() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            for (Manager m : managerList) {
                outputStream.writeObject(m);
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
