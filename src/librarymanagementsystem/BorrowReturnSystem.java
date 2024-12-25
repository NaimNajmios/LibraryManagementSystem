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

    Book objBook1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
    Book objBook2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780446310789");
    Book objBook3 = new Book("1984", "George Orwell", "9780451524935");
    Book objBook4 = new Book("Pride and Prejudice", "Jane Austen", "9780140430723");
    Book objBook5 = new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769535");
    Book objBook6 = new Book("The Hobbit", "J.R.R. Tolkien", "9780547928227");
    Book objBook7 = new Book("The Lord of the Rings", "J.R.R. Tolkien", "9780544003415");
    Book objBook8 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "9780747532699");
    Book objBook9 = new Book("The Da Vinci Code", "Dan Brown", "9780307474278");
    Book objBook10 = new Book("The Alchemist", "Paulo Coelho", "9780062315007");

    // Constructor
    public BorrowReturnSystem() {
        borrowList = new ArrayList<>();
        returnList = new ArrayList<>();

        // Multiple users borrow The Great Gatsby
        addBorrowRequestInternal("John Doe", objBook1);
        addBorrowRequestInternal("Jane Smith", objBook1);
        addBorrowRequestInternal("Michael Johnson", objBook1);

        // Multiple users borrow Harry Potter
        addBorrowRequestInternal("John Doe", objBook8);
        addBorrowRequestInternal("Sarah Williams", objBook8);
        addBorrowRequestInternal("Jane Smith", objBook8);

        // Multiple users borrow 1984
        addBorrowRequestInternal("Michael Johnson", objBook3);
        addBorrowRequestInternal("John Doe", objBook3);
        addBorrowRequestInternal("Sarah Williams", objBook3);

        // Individual borrowings
        addBorrowRequestInternal("Jane Smith", objBook4); // Pride and Prejudice
        addBorrowRequestInternal("Sarah Williams", objBook5); // The Catcher in the Rye
        addBorrowRequestInternal("John Doe", objBook6); // The Hobbit
        addBorrowRequestInternal("Jane Smith", objBook7); // The Lord of the Rings
        addBorrowRequestInternal("Michael Johnson", objBook9); // The Da Vinci Code
        addBorrowRequestInternal("Sarah Williams", objBook10); // The Alchemist

        // Returns - some users returning shared books
        addReturnRequestInternal("John Doe", objBook1); // Returns Great Gatsby
        addReturnRequestInternal("Jane Smith", objBook8); // Returns Harry Potter
        addReturnRequestInternal("Michael Johnson", objBook3); // Returns 1984
        addReturnRequestInternal("Sarah Williams", objBook5); // Returns Catcher in the Rye
        addReturnRequestInternal("Jane Smith", objBook1); // Returns Great Gatsby
        addReturnRequestInternal("Michael Johnson", objBook1); // Returns Great Gatsby
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

    // Return ArrayList of list of user in borrowing list
    public ArrayList<String> getUserInBorrowingList() {
        ArrayList<String> userList = new ArrayList<>();
        for (BorrowingReturn borrowRequest : borrowList) {
            userList.add(borrowRequest.getUser());
        }
        return userList;
    }

    // Return ArrayList of list of book in borrowing list
    public ArrayList<Book> getBookInBorrowingList() {
        ArrayList<Book> bookList = new ArrayList<>();
        for (BorrowingReturn borrowRequest : borrowList) {
            bookList.add(borrowRequest.getBook());
        }
        return bookList;
    }

}