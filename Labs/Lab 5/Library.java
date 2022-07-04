import java.util.ArrayList;
import java.util.Collections;

public class Library {

    private ArrayList<Book> library = new ArrayList<Book>();


    public Book getBook(int i) {
      return library.get(i);
    }

    public int getSize() {
      return library.size();
    }

    public void addBook (Book b) {
      // Your code here
      library.add(b);
    }

    public void sort() {
      // Your code here
      Collections.sort(library, new BookComparator());
    }


    public void printLibrary() {
      // Your code here
      System.out.println(library);
    }
}