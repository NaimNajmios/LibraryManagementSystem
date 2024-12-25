package librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {

    private Node first; // Head node of the linked list

    // LinkList constructor
    public BookCollection() {
        first = null;
        // Books by Stephen King
        Book objBook1 = new Book("The Shining", "Stephen King", "9780307743657");
        Book objBook2 = new Book("It", "Stephen King", "9781982127794");
        Book objBook3 = new Book("The Stand", "Stephen King", "9780307743680");
        Book objBook4 = new Book("Pet Sematary", "Stephen King", "9781982112394");

        // Books by Neil Gaiman
        Book objBook5 = new Book("American Gods", "Neil Gaiman", "9780062572110");
        Book objBook6 = new Book("Good Omens", "Neil Gaiman, Terry Pratchett", "9780060853983");
        Book objBook7 = new Book("Coraline", "Neil Gaiman", "9780380807345");

        // Books by Terry Pratchett
        Book objBook8 = new Book("The Color of Magic", "Terry Pratchett", "9780062225672");
        Book objBook9 = new Book("Guards! Guards!", "Terry Pratchett", "9780062225757");

        // Books by Margaret Atwood
        Book objBook10 = new Book("The Handmaid's Tale", "Margaret Atwood", "9780385490818");
        Book objBook11 = new Book("The Testaments", "Margaret Atwood", "9780385543781");
        Book objBook12 = new Book("Oryx and Crake", "Margaret Atwood", "9780385721677");

        // Books with Multiple Authors
        Book objBook13 = new Book("Beautiful Creatures", "Kami Garcia, Margaret Stohl", "9780316231657");
        Book objBook14 = new Book("The Talisman", "Stephen King, Peter Straub", "9781501192272");
        Book objBook15 = new Book("Welcome to Night Vale", "Joseph Fink, Jeffrey Cranor", "9780062351425");

        // Books by Brandon Sanderson
        Book objBook16 = new Book("The Way of Kings", "Brandon Sanderson", "9780765326355");
        Book objBook17 = new Book("Mistborn: The Final Empire", "Brandon Sanderson", "9780765350381");
        Book objBook18 = new Book("Elantris", "Brandon Sanderson", "9780765350374");

        // Preston & Child Series
        Book objBook19 = new Book("Relic", "Douglas Preston, Lincoln Child", "9781455582228");
        Book objBook20 = new Book("Cabinet of Curiosities", "Douglas Preston, Lincoln Child", "9780446611231");

        // Individual Authors
        Book objBook21 = new Book("The Da Vinci Code", "Dan Brown", "9780307474278");
        Book objBook22 = new Book("Project Hail Mary", "Andy Weir", "9780593135204");

        // Books by James S. A. Corey (Pseudonym for Daniel Abraham and Ty Franck)
        Book objBook23 = new Book("Leviathan Wakes", "James S. A. Corey", "9780316129084");
        Book objBook24 = new Book("Caliban's War", "James S. A. Corey", "9780316129060");

        // Scientific Collaborations
        Book objBook25 = new Book("The Grand Design", "Stephen Hawking, Leonard Mlodinow", "9780553384666");
        Book objBook26 = new Book("Welcome to the Universe", "Neil deGrasse Tyson, Michael A. Strauss, J. Richard Gott",
                "9780691157245");

        // Writing Craft Books
        Book objBook27 = new Book("On Writing", "Stephen King", "9781439156810");
        Book objBook28 = new Book("The Art of Fiction", "John Gardner", "9780679734031");

        // More Multiple Authors
        Book objBook29 = new Book("Heart of Iron", "Ashley Poston, Emily Woo Zeller", "9780062652850");
        Book objBook30 = new Book("The Oracle Year", "Charles Soule, Emily Woo Zeller", "9780062686633");

        addFirst(objBook1);
        addFirst(objBook2);
        addFirst(objBook3);
        addFirst(objBook4);
        addFirst(objBook5);
        addFirst(objBook6);
        addFirst(objBook7);
        addFirst(objBook8);
        addFirst(objBook9);
        addFirst(objBook10);
        addFirst(objBook11);
        addFirst(objBook12);
        addFirst(objBook13);
        addFirst(objBook14);
        addFirst(objBook15);
        addFirst(objBook16);
        addFirst(objBook17);
        addFirst(objBook18);
        addFirst(objBook19);
        addFirst(objBook20);
        addFirst(objBook21);
        addFirst(objBook22);
        addFirst(objBook23);
        addFirst(objBook24);
        addFirst(objBook25);
        addFirst(objBook26);
        addFirst(objBook27);
        addFirst(objBook28);
        addFirst(objBook29);
        addFirst(objBook30);
    }

    // Returns true if the list is empty
    public boolean isEmpty() {
        return (first == null);
    }

    // Insert a new node at the beginning of the linked list
    public void addFirst(Book book) {
        Node node = new Node(book);
        node.setNextNode(first);
        first = node;
    }

    // Deletes the node at the first of the linked list
    public Book deleteFirst() { // Return Book instead of Node
        if (isEmpty()) {
            System.out.println("Cannot delete from an empty list.");
            return null; // Or throw an exception if appropriate
        }
        Book tempBook = first.getBook();
        first = first.getNextNode();
        System.out.println(tempBook.getTitle() + " has been deleted.");
        return tempBook;
    }

    // Prints the linked list data from the first node to the last with number
    public void printList() {
        if (isEmpty()) {
            System.out.println("The book collection is empty.");
            return;
        }
        Node current = first;
        int count = 1;
        while (current != null) {
            System.out.println(count + current.getBook().toString());
            current = current.getNextNode();
            count++;
        }
    }

    // Prints the linked list data from the first node to the last with number
    public void printListWONumber() {
        if (isEmpty()) {
            System.out.println("The book collection is empty.");
            return;
        }
        Node current = first;
        while (current != null) {
            System.out.println(current.getBook().toString());
            current = current.getNextNode();
        }
    }

    // Get first book in the list
    public Book getFirstBook() {
        if (isEmpty()) {
            System.out.println("The book collection is empty.");
            return null;
        }
        return first.getBook();
    }

    // Get book by position on list (1-based index)
    public Book getBook(int position) {
        if (position <= 0) {
            System.out.println("Invalid book position. Please enter a positive number");
            return null;
        }

        Node current = first;
        int count = 1;
        while (current != null) {
            if (count == position) {
                return current.getBook();
            }
            current = current.getNextNode();
            count++;
        }
        System.out.println("Book at position " + position + " not found.");
        return null;
    }

    // Get size of the linked list
    public int size() {
        Node current = first;
        int count = 0;
        while (current != null) {
            count++;
            current = current.getNextNode();
        }
        return count;
    }

    // Print the details of book based on the position on list (1-based index)
    public void printBook(int position) {
        Book book = getBook(position);
        if (book != null) {
            System.out.println(book.toString());
        }
    }

    // Method to delete a book by ISBN
    public void deleteBook(String isbn) {
        Node current = first;
        Node previous = null;

        while (current != null) {
            if (current.getBook().getIsbn().equals(isbn)) {
                if (previous == null) {
                    first = current.getNextNode();
                } else {
                    previous.setNextNode(current.getNextNode());
                }
                System.out.println("Book with ISBN " + isbn + " has been deleted.");
                return;
            }
            previous = current;
            current = current.getNextNode();
        }

        System.out.println("Book with ISBN " + isbn + " not found.");
    }

    // Method to get a book at a specific node (0-based index)
    public Book getBookAtNode(int index) {
        Node current = first;
        int i = 0;

        while (current != null && i < index) {
            current = current.getNextNode();
            i++;
        }

        return (current != null) ? current.getBook() : null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = first;

        while (current != null) {
            sb.append(current.getBook().toString()).append("\n");
            current = current.getNextNode();
        }

        return sb.toString();
    }

    public List<Book> getBookList() {
        List<Book> bookList = new ArrayList<>();
        Node current = first;
        while (current != null) {
            bookList.add(current.getBook());
            current = current.getNextNode();
        }
        return bookList;
    }

}