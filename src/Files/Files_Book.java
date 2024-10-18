package Files;

import java.io.*;
import java.util.List;

import Model.Author;
import Model.Book;
import Model.Genres;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class Files_Book {

	public static final String FILE_PATH = "src/BinaryFiles/Book.dat";
    private static final File DATA_FILE = new File(FILE_PATH);
    private ObservableList<Book> listbook = FXCollections.observableArrayList();
    private ObservableMap<Book, Integer> soldBooksMap = FXCollections.observableHashMap();;

    public  void addSoldBook(Book book , int cnt) {
    	soldBooksMap.put(book, cnt);
    }
    


    public ObservableList<Book> getListbook() {
		return listbook;
	}


	public void setListbook(ObservableList<Book> listbook) {
		this.listbook = listbook;
	}


	public ObservableMap<Book, Integer> getSoldBooksMap() {
		return soldBooksMap;
	}


	public void setSoldBooksMap(ObservableMap<Book, Integer> soldBooksMap) {
		this.soldBooksMap = soldBooksMap;
	}


	public static String getFilePath() {
		return FILE_PATH;
	}


	public static File getDataFile() {
		return DATA_FILE;
	}

	
	 public ObservableList<Book> getAll() {
	        loadBookFromFile();
	        for (Book book : listbook) {
				System.out.println(book);
			}
	        return listbook;
	    }

	public  ObservableList<Book> loadBookFromFile() {
		updateAll();	
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
	        System.out.println("Reading books from file...");
	        
	        while (inputStream.available() > 0) {
	            Book book = (Book) inputStream.readObject();
	            System.out.println();
	            listbook.add(book);
	        }
	        System.out.println("Reading complete.");
	    } catch (EOFException e) {
	        System.out.println("End of file reached.");
	    } catch (IOException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	    }
	    return listbook;
	}

	 public boolean create(Book book) {
	  
		 try(FileOutputStream outputStream = new FileOutputStream(DATA_FILE, true)) {
	            ObjectOutputStream writer;
	            if (DATA_FILE.length() > 0)
	                writer = new HeaderlessObjectOutputStream(outputStream);
	            else
	                writer = new ObjectOutputStream(outputStream);
	            writer.writeObject(book);
	            System.out.println(book);
	            listbook.add(book);
	       	 updateAll() ;
	            return true;
	        } catch(IOException ex) {
	            return false;
	        }
	    }

  
	public static void seedData() {
        File file = new File(Files_Book.FILE_PATH);
        if (file.length() == 0) {
            Book[] books = {
                    new Book("978-1-234567-890", "Kein and Abel", new Author("Jeffrey", "Archer"), 732, 5,
                            Genres.Biography_Autobiography, 15.0,
                            "This book is the shocking story of two men, the son of a Polish immigrant, and the other, the son of a privileged rich man from a family of wealthy Boston bankers. Abel Rosnovski, a poverty-stinging survivor, survives hardship, is persistent, emigrates to the United States and sets up a network of prestigious hotels."),
                    new Book("979-3-210987-654", "To Kill a Mockingbird", new Author("Harper", "Lee"), 281, 3,
                            Genres.Adventure, 20.0,
                            "Set in the American South during the Depression, To Kill a Mockingbird takes the reader to the roots of human behavior. Scout Finch lives with her brother Jem and their father Atticus, a lawyer, in a quiet town. The story deals with racial injustice and the destruction of innocence."),
                    new Book("978-9-876543-210", "The Great Gatsby", new Author("F. Scott", "Fitzgerald"), 180, 8,
                            Genres.History, 13.0,
                            "The Great Gatsby is a classic novel that explores themes of decadence, idealism, and excess. Jay Gatsby, a mysterious millionaire, throws lavish parties to win the love of Daisy Buchanan, a woman who married another man while Gatsby served in World War I.")

            };
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
                for (Book book : books) {
                    outputStream.writeObject(book);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @SuppressWarnings("unlikely-arg-type")
    public boolean delete(Book book) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            for (Book b : listbook) {
                if (!b.equals(listbook))
                    outputStream.writeObject(b);
            }
            listbook.remove(book);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    @SuppressWarnings("unlikely-arg-type")
    public boolean deleteAll(List<Book> bookToRemove) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            for (Book b : listbook) {
                if (!bookToRemove.contains(listbook))
                    outputStream.writeObject(b);
            }
            listbook.removeAll(bookToRemove);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public boolean updateAll() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            for (Book b : listbook) {
                outputStream.writeObject(b);
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
