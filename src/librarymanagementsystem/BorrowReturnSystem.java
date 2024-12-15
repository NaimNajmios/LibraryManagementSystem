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
        return "User: " + user + "\nBook: \n" + book.getTitle();
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
        return "User: " + user + "\nBook: \n" + book.getTitle();
    }

}

public class BorrowReturnSystem {

    // Variables
    private ArrayList<BorrowingReturn> borrowList;
    private ArrayList<ReturningBook> returnList;

    // Constructor
    public BorrowReturnSystem() {
        borrowList = new ArrayList<>();
        returnList = new ArrayList<>();
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
            // Print a message
            System.out.println("Pending Borrow Requests:\n");
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
            // Print a message
            System.out.println("Pending return Requests:\n");
            for (ReturningBook request : returnList) {
                System.out.println(request);
            }
        }
    }
}