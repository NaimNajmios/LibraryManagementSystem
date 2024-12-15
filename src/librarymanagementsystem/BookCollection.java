package librarymanagementsystem;

public class BookCollection { 

    private Node first;

    // LinkList constructor
    public BookCollection() {
        first = null;
    }

    // Returns true if the list is empty
    public boolean isEmpty() {
        return (first == null);
    }

    // Insert a new node at the first of the linked list
    public void addFirst(Book book) {
        Node node = new Node(book);
        node.setNextNode(first);
        setFirst(node);
        System.out.println(book.getTitle() + " has been added to the collection.");
    }

    // Deletes the node at the first of the linked list
    public Node deleteFirst() {
        Node temp = first;
        setFirst(first.getNextNode());
        // Return the deleted node
        System.out.println(temp.getBook().getTitle() + " has been deleted.");
        return temp;
    }

    // Setter first node
    public void setFirst(Node first) {
        this.first = first;
    }

    // Prints the linked list data from the first node to the last
    public void printList() {
        Node current = first;
        // With numbering
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.getBook().toString());
            current = current.getNextNode();
            count++;
        }
    }

    // Get the first book
    public Book getFirst() {
        return first.getBook();
    }

    // Get book by position on list
    public Book getBook(int position) {
        Node current = first;
        int count = 1;
        while (current != null) {
            if (count == position) {
                return current.getBook();
            }
            current = current.getNextNode();
            count++;
        }
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

    // Print the details of book based on the position on list
    public void printBook(int position) {
        Node current = first;
        int count = 1;
        while (current != null) {
            if (count == position) {
                System.out.println(current.getBook().toString());
                break;
            }
            current = current.getNextNode();
            count++;
        }
    }
    
} 