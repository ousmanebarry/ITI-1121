import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    // Implement the comparator method for books.
    public int compare(Book o, Book t) {
        if(o.getAuthor() != t.getAuthor()) {
            return o.getAuthor().compareTo(t.getAuthor());
        } else if (o.getTitle() != t.getTitle()) {
            return o.getTitle().compareTo(t.getTitle());    
        } else {
            if(o.getYear() == t.getYear()) {
                return 0;
            } else if (o.getYear() > t.getYear()) {
                return 1;
            } else {
                return -1;
            }
        }
        
    }
}