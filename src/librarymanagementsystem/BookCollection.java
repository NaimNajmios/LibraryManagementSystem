package librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {

    private Node first; // Head node of the linked list

    // LinkList constructor
    public BookCollection() {
        first = null;
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
        System.out.println(book.getTitle() + " has been added to the collection.");
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

    // Prints the linked list data from the first node to the last
    public void printList() {
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