package librarymanagementsystem;

public class Node { 

    // Node element
    private Book book;
    private Node nextNode;

    // Constructor
    public Node(Book objBook) {
        this.book = objBook;
        // Next node initially set to null
        this.nextNode = null;
    }

    // Setter and getter
    public Book getBook() {
        return this.book;
    }

    public void setBook(Book objBook) {
        this.book = objBook;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(Node objNode) {
        this.nextNode = objNode;
    }

    // Print node data
    public void printNode() {
        System.out.println(this.book.toString());
        if (this.nextNode != null) {
            this.nextNode.printNode();
        }
    }

}