public class Book {

    // Your variables declaration here
    String author;
    String title;
    int year;

    public Book (String author, String title, int year) {
      // Your code here
      this.author = author;
      this.title = title;
      this.year = year;
    }

    public String getAuthor() {
      // Your code here
      return this.author;
    }

    public String getTitle() {
      // Your code here
      return this.title;
    }
    
    public int getYear() {
      // Your code here
      return this.year;
    }

    public boolean equals(Object other) {
      // Your code here

      if(this == other) return true;

      if(other == null || getClass() != other.getClass()) return false;

      Book book = (Book) other;

      if(this.author == null || book.author == null || this.title == null || book.title == null) {        
        return this.author == book.author && this.title == book.title && this.year == book.year;
      } else {
        return this.author.equals(book.author) && this.title.equals(book.title) && this.year == book.year;
      }


    }

    public String toString() {
      // Your code here
      return this.author + ": " + this.title + " (" + this.year + ")";
    }
}