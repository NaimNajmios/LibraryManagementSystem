package librarymanagementsystem;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {

    private BookCollection bookCollection;
    private BorrowReturnSystem borrowReturnSystem;
    private BookSearch searcher;
    private Scanner scanner;
    String bookDetail = String.format("%s| %-30s | %-25s | %-13s |", "No.", "Title", "Author", "ISBN");
    String bookDetailWONumber = String.format("%-30s | %-25s | %-13s |", "Title", "Author", "ISBN");
    String userDetail = String.format("| %-30s | %-25s |", "Visitor", "Book");

    public LibraryManagementSystem() {
        bookCollection = new BookCollection();
        borrowReturnSystem = new BorrowReturnSystem();
        scanner = new Scanner(System.in);
        searcher = new BookSearch(bookCollection);
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
                case 5:
                    handleRecommendationMenu();
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
                    displayBookCollection();
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

    private void handleRecommendationMenu() {
        boolean inRecommendationMenu = true;
        while (inRecommendationMenu) {
            printBookRecommendationMenu();
            int recommendationChoice = getIntInput("Enter your choice: ");
            switch (recommendationChoice) {
                case 1:
                    recommendBooksByUser();
                    break;
                case 2:
                    inRecommendationMenu = false; // Return to main menu
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
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
        System.out.println("5. Book Recommendation");
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

    private void printBookRecommendationMenu() {
        System.out.println();
        System.out.println("Book Recommendation Menu:");
        System.out.println("1. Book Recommendation By User");
        System.out.println("2. Main Menu");
        System.out.println();
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
        newBook.toString();
        System.out.println("\nBook added successfully!");
    }

    private void deleteBook() {
        bookCollection.printList();
        if (!bookCollection.isEmpty()) { // Check if the collection is not empty
            System.out.println("Enter the position of the book you want to delete: ");
            displayBookCollection();
            int position = getIntInput("Position: ");
            if (position > 0 && position <= bookCollection.size()) {
                bookCollection.deleteBook(bookCollection.getBook(position).getIsbn());
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("Invalid book position. Please enter a valid position.");
            }
        }
    }

    // Method to display the book collection
    private void displayBookCollection() {
        System.out.println("\nBook Collection:");
        System.out.println(bookDetail);
        bookCollection.printList();
    }

    private void borrowBook() {
        if (isBookCollectionEmpty()) {
            System.out.println("There are no books to borrow.");
            return;
        }
        String userName = getStringInput("Enter user name: ");
        // Display book collection
        displayBookCollection();
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
        displayBookCollection();
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
        System.out.println("\nBorrowing Requests:");
        System.out.println(userDetail);
        borrowReturnSystem.displayBorrowPendingRequests();
    }

    // Display Return Requests
    private void displayReturnRequests() {
        System.out.println("\nReturn Requests:");
        System.out.println(userDetail);
        borrowReturnSystem.displayReturnPendingRequests();
    }

    // Process borrow requests
    private void processBorrowRequests() {
        System.out.println("\nBorrowing Requests:");
        System.out.println(userDetail);
        borrowReturnSystem.displayBorrowPendingRequests();
        System.out.println();

        borrowReturnSystem.processBorrowRequest();
        System.out.println("\nUpdated Borrowing Requests:");
        System.out.println(userDetail);
        borrowReturnSystem.displayBorrowPendingRequests();
    }

    // Process return requests
    private void processReturnRequests() {
        System.out.println("\nReturn Requests:");
        System.out.println(userDetail);
        borrowReturnSystem.displayReturnPendingRequests();
        System.out.println();

        borrowReturnSystem.processReturnRequest();
        System.out.println("\nUpdated Return Requests:");
        System.out.println(userDetail);
        borrowReturnSystem.displayReturnPendingRequests();
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

    // Handle search book menu by title
    private void searchBookByTitle() {
        System.out.println("Enter book title: ");
        String title = scanner.nextLine();
        List<Book> book = searcher.searchAllByTitle(title);
        if (book != null) {
            System.out.println("\nBooks found: ");
            System.out.println(bookDetailWONumber);
            for (Book b : book) {
                System.out.println(b.toString());
            }
        } else {
            System.out.println("\nBook not found.");
        }
    }

    // Handle search book menu by ISBN
    private void searchBookByISBN() {
        System.out.println("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        Book book = searcher.searchISBN(isbn);
        if (book != null) {
            System.out.println("\nBook found: ");
            System.out.println(bookDetailWONumber);
            System.out.println(book.toString());
        } else {
            System.out.println("\nBook not found.");
        }
    }

    // Handle search book menu by author
    private void searchBookByAuthor() {
        System.out.println("Enter author name: ");
        String author = scanner.nextLine();
        List<Book> book = searcher.searchAllByAuthor(author);
        if (book != null) {
            System.out.println("\nBooks found: ");
            System.out.println(bookDetailWONumber);
            for (Book b : book) {
                System.out.println(b.toString());
            }
        } else {
            System.out.println("\nBook not found.");
        }
    }

    private void quickSortBooks() {
        List<Book> booksToSort = bookCollection.getBookList();
        SortBook sorter = new SortBook();
        System.out.println("\nBefore Sort:");
        System.out.println(bookDetailWONumber);
        for (Book book : booksToSort) {
            System.out.println(book.toString());
        }
        sorter.quickSort(booksToSort, 0, booksToSort.size() - 1);
        System.out.println("\nSorted List (Quick Sort):");
        System.out.println(bookDetailWONumber);
        for (Book book : booksToSort) {
            System.out.println(book.toString());
        }
    }

    private void bubbleSortBooks() {
        List<Book> booksToSort = bookCollection.getBookList();
        SortBook sorter = new SortBook();
        System.out.println("\nBefore Sort:");
        System.out.println(bookDetail);
        for (Book book : booksToSort) {
            System.out.println(book.toString());
        }
        sorter.bubbleSort(booksToSort);
        System.out.println("\nSorted List (Bubble Sort):");
        System.out.println(bookDetailWONumber);
        for (Book book : booksToSort) {
            System.out.println(book.toString());
        }
    }

    private void mergeSortBooks() {
        List<Book> booksToSort = bookCollection.getBookList();
        SortBook sorter = new SortBook();
        System.out.println("\nBefore Sort:");
        System.out.println(bookDetailWONumber);
        for (Book book : booksToSort) {
            System.out.println(book.toString());
        }
        sorter.mergeSort(booksToSort);
        System.out.println("\nSorted List (Merge Sort):");
        System.out.println(bookDetailWONumber);
        for (Book book : booksToSort) {
            System.out.println(book.toString());
        }
    }

    // Method to recommend books based on user's borrowing history
    private void recommendBooksByUser() {
        System.out.println("Enter user name: ");
        String userName = scanner.nextLine();
        BookRecommendation bookRecommendation = new BookRecommendation(borrowReturnSystem.getUserInBorrowingList(),
                borrowReturnSystem.getBookInBorrowingList());
        List<String> recommendedBooks = bookRecommendation.recommendBooks(userName);
        if (recommendedBooks != null) {
            System.out.println("\nRecommended Books for " + userName + ":");
            for (String book : recommendedBooks) {
                System.out.println(book);
            }
        } else {
            System.out.println("\nNo recommendations available for " + userName);
        }
    }
}