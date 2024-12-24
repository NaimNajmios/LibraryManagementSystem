package librarymanagementsystem;

public class Book {
    
    // Attributes
    private String title;
    private String author;
    private String isbn;
    Book left;
    Book right;

    // Default constructor
    public Book() {}

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Setter and getter methods

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String toString() {
        return String.format("| %-30s | %-25s | %-13s |", this.title, this.author, this.isbn);
    }


}
