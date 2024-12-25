package librarymanagementsystem;

import java.util.ArrayList;

class BorrowingReturn {

    // Variables
    String user;
    Book book;

    // Constructor
    public BorrowingReturn(String user, Book book) {
        setUser(user);
        setBook(book);


    }

    // Setter and getter
    public void setUser(String user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    // ToString method
    public String toString() {
        return String.format("| %-30s | %-25s |", this.user, this.book.getTitle());
    }

}

class ReturningBook {

    // Variables
    String user;
    Book book;

    // Constructor
    public ReturningBook(String user, Book book) {
        setUser(user);
        setBook(book);
    }

    // Setter and getter
    public void setUser(String user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    // ToString method
    public String toString() {
        return String.format("| %-30s | %-25s |", this.user, this.book.getTitle());
    }

}

public class BorrowReturnSystem {

    // Variables
    private ArrayList<BorrowingReturn> borrowList;
    private ArrayList<ReturningBook> returnList;

    Book objBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
    Book objBook2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780446310789");
    Book objBook3 = new Book("Pride and Prejudice", "Jane Austen", "9780140430723");
    Book objBook4 = new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769535");

    // Constructor
    public BorrowReturnSystem() {
        borrowList = new ArrayList<>();
        returnList = new ArrayList<>();

        addBorrowRequestInternal("John Doe", objBook);
        addBorrowRequestInternal("Jane Smith", objBook2);

        addReturnRequestInternal("Adam Bryant", objBook3);
        addReturnRequestInternal("Helen Osborne", objBook4);

    }

    // Add a borrow request to the list
    public void addBorrowRequest(String userName, Book book) {
        // Create a new borrow request
        BorrowingReturn borrowRequest = new BorrowingReturn(userName, book);
        // Add the borrowRequest to the list
        borrowList.add(borrowRequest);
        // Print a message
        System.out.println("Borrow request added: \n" + borrowRequest);
    }

    public void addBorrowRequestInternal(String userName, Book book) {
        // Create a new borrow request
        BorrowingReturn borrowRequest = new BorrowingReturn(userName, book);
        // Add the borrowRequest to the list
        borrowList.add(borrowRequest);
    }

    
    // Process the next borrow request in the list (FIFO behavior)
    public void processBorrowRequest() {
        // If the list is empty, print a message
        if (borrowList.isEmpty()) {
            System.out.println("No borrow requests to process.");
        } else {
            // Remove the first request from the list
            BorrowingReturn processedRequest = borrowList.remove(0); // Remove from the front of the list
            System.out.println("Processing borrow request: \n" + processedRequest);
        }
    }

    // Display all pending borrow requests
    public void displayBorrowPendingRequests() {
        // If the list is empty, print a message
        if (borrowList.isEmpty()) {
            System.out.println("No pending borrow requests.");
        } else {
            for (BorrowingReturn borrowRequest : borrowList) {
                System.out.println(borrowRequest);
            }
        }
    }

    // Add a borrow request to the list
    public void addReturnRequest(String userName, Book book) {
        // Create a new borrow request
        ReturningBook returnRequest = new ReturningBook(userName, book);
        // Add the request to the list
        returnList.add(returnRequest);
        // Print a message
        System.out.println("Return request added: \n" + returnRequest);
    }

    // Add a borrow request to the list
    public void addReturnRequestInternal(String userName, Book book) {
        // Create a new borrow request
        ReturningBook returnRequest = new ReturningBook(userName, book);
        // Add the request to the list
        returnList.add(returnRequest);
    }


    // Process the next borrow request in the list (FIFO behavior)
    public void processReturnRequest() {
        // If the list is empty, print a message
        if (returnList.isEmpty()) {
            System.out.println("No return requests to process.");
        } else {
            // Remove the first request from the list
            ReturningBook processedRequest = returnList.remove(0); // Remove from the front of the list
            System.out.println("Processing return request: \n" + processedRequest);
        }
    }

    // Display all pending borrow requests
    public void displayReturnPendingRequests() {
        // If the list is empty, print a message
        if (returnList.isEmpty()) {
            System.out.println("No pending return requests.");
        } else {
            for (ReturningBook request : returnList) {
                System.out.println(request);
            }
        }
    }
}