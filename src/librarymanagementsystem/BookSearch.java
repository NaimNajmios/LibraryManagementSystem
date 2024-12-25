package librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

class BookSearch {

    // Instatiate book object
    private Book root;

    // Constructor
    public BookSearch() {
        this.root = null;
    }

    // Constructor with parameter BookCollection
    public BookSearch(BookCollection bookCollection) {
        this.root = bookCollection.getFirstBook();
        // Insert all books from the collection into the binary tree using loop
        for (int i = 2; i <= bookCollection.size(); i++) {
            insertRec(root, bookCollection.getBook(i));
        }
    }

    public void insertRec(Book book) {
        root = insertRec(root, book);
    }

    // Insert book collection using node
    private Book insertRec(Book currentNode, Book newBook) {
        if (currentNode == null) {
            return newBook;
        }
        // Compare isbn value
        if (newBook.getIsbn().compareTo(currentNode.getIsbn()) < 0) {
            currentNode.left = insertRec(currentNode.left, newBook);
        } else if (newBook.getIsbn().compareTo(currentNode.getIsbn()) > 0) {
            currentNode.right = insertRec(currentNode.right, newBook);
        }
        return currentNode;
    }

    // Seacrh by isbn
    public Book searchISBN(String isbn) {
        return searchISBN(root, isbn);
    }

    private Book searchISBN(Book root, String isbn) {
        if (root == null || root.getIsbn().equals(isbn)) {
            return root;
        }
        if (isbn.compareTo(root.getIsbn()) < 0) {   
            return searchISBN(root.left, isbn);
        }
        return searchISBN(root.right, isbn);
    }

    // Search by title (returns a list of books)
    public List<Book> searchAllByTitle(String title) {
        return searchAllByTitle(root, title, new ArrayList<>());
    }

    private List<Book> searchAllByTitle(Book root, String title, List<Book> results) {
        if (root == null) {
            return results; // Return the current results
        }

        if (root.getTitle().equals(title)) {
            results.add(root); // Add the matching book to the results
        }

        // Continue searching both subtrees regardless of finding a match
        searchAllByTitle(root.left, title, results);
        searchAllByTitle(root.right, title, results);

        return results; // Return the accumulated results
    }

    // Search by author (returns a list of books)
    public List<Book> searchAllByAuthor(String author) {
        return searchAllByAuthor(root, author, new ArrayList<>());
    }

    private List<Book> searchAllByAuthor(Book root, String author, List<Book> results) {
        if (root == null) {
            return results; // Return the current results
        }

        if (root.getAuthor().equals(author)) {
            results.add(root); // Add the matching book to the results
        }

        // Continue searching both subtrees regardless of finding a match
        searchAllByAuthor(root.left, author, results);
        searchAllByAuthor(root.right, author, results);

        return results; // Return the accumulated results
    }

    // In-order Traversal
    public void printInOrder() {
        printInOrderRec(root);
    }

    private void printInOrderRec(Book currentNode) {
        if (currentNode != null) {
            printInOrderRec(currentNode.left); // Traverse left subtree
            System.out.println("ISBN: " + currentNode.getIsbn() +
                    ", Title: " + currentNode.getTitle() +
                    ", Author: " + currentNode.getAuthor());
            printInOrderRec(currentNode.right); // Traverse right subtree
        } else {
            return;
        }
    }

}