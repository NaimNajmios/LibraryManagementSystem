package librarymanagementsystem;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {

    private final BookCollection bookCollection;
    private final BorrowReturnSystem borrowReturnSystem;
    private final BookSearch searcher;
    private final Scanner scanner;

    public LibraryManagementSystem() {
        bookCollection = new BookCollection();
        borrowReturnSystem = new BorrowReturnSystem();
        scanner = new Scanner(System.in);
        initializeBooks();
        searcher = new BookSearch(bookCollection);
    }

    private void initializeBooks() {
        // Instantiate 10 books
        Book objBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        Book objBook2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780446310789");
        Book objBook3 = new Book("Pride and Prejudice", "Jane Austen", "9780140430723");
        Book objBook4 = new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769535");
        Book objBook5 = new Book("The Lord of the Rings", "J.R.R. Tolkien", "9780439136366");
        Book objBook6 = new Book("The Hobbit", "J.R.R. Tolkien", "9780439136365");
        Book objBook7 = new Book("The Alchemist", "Paulo Coelho", "9780061122415");

        bookCollection.addFirst(objBook);
        bookCollection.addFirst(objBook2);
        bookCollection.addFirst(objBook3);
        bookCollection.addFirst(objBook4);
        bookCollection.addFirst(objBook5);
        bookCollection.addFirst(objBook6);
        bookCollection.addFirst(objBook7);

    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        library.run();
    }

    public void run() {
        printWelcomeMessage();
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    handleBookCollectionMenu();
                    break;
                case 2:
                    handleSearchBookMenu();
                    break;
                case 3:
                    handleBorrowMenu();
                    break;
                case 4:
                    handleSortMenu();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Exiting Library Management System. Goodbye!");
        scanner.close();
    }

    private void handleBookCollectionMenu() {
        boolean inBookMenu = true;
        while (inBookMenu) {
            printBookCollectionMenu();
            int bookChoice = getIntInput("Enter your choice: ");
            switch (bookChoice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    bookCollection.printList();
                    break;
                case 4:
                    inBookMenu = false; // Return to main menu
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Handle search book menu
    private void handleSearchBookMenu() {
        boolean inSearchMenu = true;
        while (inSearchMenu) {
            printSearchBookMenu();
            int searchChoice = getIntInput("Enter your choice: ");
            switch (searchChoice) {
                case 1:
                    searchBookByISBN();
                    break;
                case 2:
                    searchBookByTitle();
                    break;
                case 3:
                    searchBookByAuthor();
                    break;
                case 4:
                    inSearchMenu = false; // Return to main menu
                    break;
            }
        }
    }

    private void handleBorrowMenu() {
        boolean inBorrowMenu = true;
        while (inBorrowMenu) {
            printBorrowMenu();
            int borrowChoice = getIntInput("Enter your choice: ");

            switch (borrowChoice) {
                case 1:
                    borrowBook();
                    break;
                case 2:
                    returnBook();
                    break;
                case 3:
                    displayBorrowRequests();
                    break;
                case 4:
                    displayReturnRequests();
                    break;
                case 5:
                    processBorrowRequests();
                    break;
                case 6:
                    processReturnRequests();
                    break;
                case 7:
                    inBorrowMenu = false; // Return to main menu
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Handle sort menu
    private void handleSortMenu() {
        boolean inSortMenu = true;
        while (inSortMenu) {
            printSortMenu();
            int sortChoice = getIntInput("Enter your choice: ");
            switch (sortChoice) {
                case 1:
                    quickSortBooks();
                    break;
                case 2:
                    bubbleSortBooks();
                    break;
                case 3:
                    mergeSortBooks();
                    break;
                case 4:
                    inSortMenu = false; // Return to main menu
                    break;
            }
        }
    }

    private void printWelcomeMessage() {
        System.out.println("------------------------------------------------");
        System.out.println("Welcome to the Library Management System");
        System.out.println("------------------------------------------------");
        System.out.println();
    }

    private void printMainMenu() {
        System.out.println();
        System.out.println("Main Menu:");
        System.out.println("1. Manage Book Collection");
        System.out.println("2. Search Book");
        System.out.println("3. Borrow & Return system");
        System.out.println("4. Sort Book");
        System.out.println("7. Exit");
        System.out.println();
    }

    private void printSortMenu() {
        System.out.println();
        System.out.println("Sort Menu:");
        System.out.println("1. Quick Sort");
        System.out.println("2. Bubble Sort");
        System.out.println("3. Merge Sort");
        System.out.println("4. Back to Main Menu");
        System.out.println();
    }

    private void printBookCollectionMenu() {
        System.out.println();
        System.out.println("Book Collection Menu:");
        System.out.println("1. Add Book");
        System.out.println("2. Delete Book");
        System.out.println("3. Display Book Collection");
        System.out.println("4. Main Menu");
        System.out.println();
    }

    private void printBorrowMenu() {
        System.out.println();
        System.out.println("Borrow/Return Menu:");
        System.out.println("1. Borrow book");
        System.out.println("2. Return book");
        System.out.println("3. Display Borrowing Requests");
        System.out.println("4. Display Return Requests");
        System.out.println("5. Accept Borrow Request");
        System.out.println("6. Accept Return Request");
        System.out.println("7. Main Menu");
        System.out.println();
    }

    private void printSearchBookMenu() {
        System.out.println();
        System.out.println("Search Book Menu:");
        System.out.println("1. Search by ISBN");
        System.out.println("2. Search by Title");
        System.out.println("3. Search by Author");
        System.out.println("4. Main Menu");
        System.out.println();
    }

    private void deleteBook() {
        bookCollection.printList();
        if (!bookCollection.isEmpty()) { // Check if the collection is not empty
            System.out.println("Enter the position of the book you want to delete: ");
            bookCollection.printList();
            int position = getIntInput("Position: ");
            if (position > 0 && position <= bookCollection.size()) {
                bookCollection.deleteBook(bookCollection.getBook(position).getIsbn());
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("Invalid book position. Please enter a valid position.");
            }
        }
    }

    private boolean isBookCollectionEmpty() {
        return bookCollection.isEmpty();
    }

    private void addBook() {
        System.out.println("Enter book details:");
        String title = getStringInput("Title: ");
        String author = getStringInput("Author: ");
        String ISBN = getStringInput("ISBN: ");
        Book newBook = new Book(title, author, ISBN);
        bookCollection.addFirst(newBook);
        System.out.println("Book added successfully!");
    }

    private void borrowBook() {
        if (isBookCollectionEmpty()) {
            System.out.println("There are no books to borrow.");
            return;
        }
        String userName = getStringInput("Enter user name: ");
        // Display book collection
        bookCollection.printList();
        int position = getIntInput("Enter book position: ");
        Book book = bookCollection.getBook(position);
        if (book != null) {
            borrowReturnSystem.addBorrowRequest(userName, book);
            System.out.println("Borrow request added.");
        } else {
            System.out.println("Invalid book position.");
        }
    }

    private void returnBook() {
        if (isBookCollectionEmpty()) {
            System.out.println("There are no books to return.");
            return;
        }
        String userName = getStringInput("Enter user name: ");
        // Display book collection
        bookCollection.printList();
        int position = getIntInput("Enter book position: ");
        Book book = bookCollection.getBook(position);
        if (book != null) {
            borrowReturnSystem.addReturnRequest(userName, book);
            System.out.println("Return request added.");
        } else {
            System.out.println("Invalid book position.");
        }
    }

    // Display Borrowing Requests
    private void displayBorrowRequests() {
        borrowReturnSystem.displayBorrowPendingRequests();
    }

    // Display Return Requests
    private void displayReturnRequests() {
        borrowReturnSystem.displayReturnPendingRequests();
    }

    // Process borrow requests
    private void processBorrowRequests() {
        borrowReturnSystem.processBorrowRequest();
    }

    // Process return requests
    private void processReturnRequests() {
        borrowReturnSystem.processReturnRequest();
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }
    }

    // Handle search book menu by ISBN
    private void searchBookByISBN() {
        String isbn = scanner.nextLine();
        Book book = searcher.searchISBN(isbn);
        if (book != null) {
            System.out.println("Book found: " + book.toString());
        } else {
            System.out.println("Book not found.");
        }
    }

    // Handle search book menu by title
    private void searchBookByTitle() {
        String title = scanner.nextLine();
        Book book = searcher.searchTitle(title);
        if (book != null) {
            System.out.println("Book found: " + book.toString());
        } else {
            System.out.println("Book not found.");
        }
    }

    // Handle search book menu by author
    private void searchBookByAuthor() {
        String author = scanner.nextLine();
        Book book = searcher.searchAuthor(author);
        if (book != null) {
            System.out.println("Book found: " + book.toString());
        } else {
            System.out.println("Book not found.");
        }
    }

    private void quickSortBooks() {
        List<Book> booksToSort = bookCollection.getBookList();
        SortBook sorter = new SortBook();
        System.out.println("\nBefore Sort:");
        for (Book book : booksToSort) {
            System.out.println(book.toString());
        }
        sorter.quickSort(booksToSort, 0, booksToSort.size() - 1);
        System.out.println("\nSorted List (Quick Sort):");
        for (Book book : booksToSort) {
            System.out.println(book.toString());
        }
    }

    private void bubbleSortBooks() {
        List<Book> booksToSort = bookCollection.getBookList();
        SortBook sorter = new SortBook();
        System.out.println("\nBefore Sort:");
        for (Book book : booksToSort) {
            System.out.println(book.toString());
        }
        sorter.bubbleSort(booksToSort);
        System.out.println("\nSorted List (Bubble Sort):");
        for (Book book : booksToSort) {
            System.out.println(book.toString());
        }
    }

    private void mergeSortBooks() {
        List<Book> booksToSort = bookCollection.getBookList();
        SortBook sorter = new SortBook();
        System.out.println("\nBefore Sort:");
        for (Book book : booksToSort) {
            System.out.println(book.toString());
        }
        sorter.mergeSort(booksToSort);
        System.out.println("\nSorted List (Merge Sort):");
        for (Book book : booksToSort) {
            System.out.println(book.toString());
        }
    }

}