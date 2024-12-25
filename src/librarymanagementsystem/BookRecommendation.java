package librarymanagementsystem;

import java.util.*;

// Class representing a Book Recommendation System
public class BookRecommendation {

    // Graph structure to hold users and books
    private Map<String, List<String>> graph;

    // Constructor to initialize the graph
    public BookRecommendation() {
        graph = new HashMap<>();
    }

    // Constructor to initialize the graph with ArrayList user and book data
    public BookRecommendation(ArrayList<String> users, ArrayList<Book> books) {
        graph = new HashMap<>();
        // Add users and books to the graph using for loop
        for (int i = 0; i < users.size(); i++) {
            String user = users.get(i);
            String book = books.get(i).getTitle();
            addBorrowing(user, book);
        }
    
    }

    // Method to add a borrowing relationship
    public void addBorrowing(String user, String book) {
        // If user does not exist in the graph, create an entry
        graph.putIfAbsent(user, new ArrayList<>());
        // Add the borrowed book to the user's list
        graph.get(user).add(book);

        // If the book does not exist in the graph, create an entry for it
        graph.putIfAbsent(book, new ArrayList<>());
    }

    // Method to recommend books based on user's borrowing history
    public List<String> recommendBooks(String user) {
        Set<String> recommendedBooks = new HashSet<>();
        Set<String> viewedBooks = new HashSet<>(); // Keep track of books already processed
        Queue<String> queue = new LinkedList<>();

        if (graph.containsKey(user)) {
            queue.addAll(graph.get(user));
            viewedBooks.addAll(graph.get(user)); // Add user's own books to viewed
        }

        while (!queue.isEmpty()) {
            String currentBook = queue.poll();

            for (String otherUser : graph.keySet()) {
                if (!otherUser.equals(user) && graph.get(otherUser).contains(currentBook)) {
                    for (String borrowedBook : graph.get(otherUser)) {
                        if (!graph.get(user).contains(borrowedBook) && !viewedBooks.contains(borrowedBook)) {
                            // Check if user has read it and if it was already processed
                            recommendedBooks.add(borrowedBook);
                            queue.add(borrowedBook);
                            viewedBooks.add(borrowedBook); // Mark book as viewed
                        }
                    }
                }
            }
        }

        return new ArrayList<>(recommendedBooks);
    }

    // Method to visualize the graph in console
    public void visualizeGraph() {
        System.out.println("Graph Visualization:");

        // Visualize from User's perspective
        System.out.println("User -> \t\t\t\tBooks:");
        int maxUserLength = 0;
        for (String user : graph.keySet()) {
            maxUserLength = Math.max(maxUserLength, user.length());
        }

        for (String user : graph.keySet()) {
            String formattedUser = String.format("%-" + maxUserLength + "s", user); // Pad with spaces
            if (!graph.get(user).isEmpty()) {
                System.out.println(formattedUser + " -> " + String.join(", ", graph.get(user)));
            }
        }

        // Visualize from Book's perspective
        System.out.println("\nBook -> \t\t\t\tUsers:");
        Map<String, List<String>> bookToUsers = new HashMap<>();
        for (String user : graph.keySet()) {
            for (String book : graph.get(user)) {
                bookToUsers.putIfAbsent(book, new ArrayList<>());
                bookToUsers.get(book).add(user);
            }
        }

        int maxBookLength = 0;
        for (String book : bookToUsers.keySet()) {
            maxBookLength = Math.max(maxBookLength, book.length());
        }

        for (String book : bookToUsers.keySet()) {
            String formattedBook = String.format("%-" + maxBookLength + "s", book); // Pad with spaces
            System.out.println(formattedBook + " -> " + String.join(", ", bookToUsers.get(book)));
        }
    }

    public static void main(String[] args) {
        BookRecommendation system = new BookRecommendation();

        // Data for 4 users with multiple books each
        system.addBorrowing("Alice", "The Hitchhiker's Guide to the Galaxy");
        system.addBorrowing("Alice", "Pride and Prejudice");
        system.addBorrowing("Alice", "To Kill a Mockingbird");
        system.addBorrowing("Alice", "The Lord of the Rings");

        system.addBorrowing("Bob", "The Hitchhiker's Guide to the Galaxy");
        system.addBorrowing("Bob", "1984");
        system.addBorrowing("Bob", "Animal Farm");
        system.addBorrowing("Bob", "The Lord of the Rings");

        system.addBorrowing("Charlie", "Pride and Prejudice");
        system.addBorrowing("Charlie", "Jane Eyre");
        system.addBorrowing("Charlie", "The Great Gatsby");

        system.addBorrowing("David", "1984");
        system.addBorrowing("David", "The Great Gatsby");
        system.addBorrowing("David", "Catch-22");
        system.addBorrowing("David", "To Kill a Mockingbird");

        system.visualizeGraph(); // Keep the visualization for debugging

        // Example recommendations
        System.out.println("\nBook Recommendations:");

        System.out.println("Recommendations for Alice: " + system.recommendBooks("Alice"));
        System.out.println("Recommendations for Bob: " + system.recommendBooks("Bob"));
        System.out.println("Recommendations for Charlie: " + system.recommendBooks("Charlie"));
        System.out.println("Recommendations for David: " + system.recommendBooks("David"));

    }
}
