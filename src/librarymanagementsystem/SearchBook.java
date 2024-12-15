package librarymanagementsystem;

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

    public void insertRec(Book book){
        root = insertRec(root, book);
    }


    //Insert book collection using node
    private Book insertRec(Book currentNode,Book newBook){
        if(currentNode == null){
            return newBook;
        }
        //Compare isbn value
        if(newBook.getIsbn().compareTo(currentNode.getIsbn()) < 0){
            currentNode.left = insertRec(currentNode.left, newBook);
        }else if(newBook.getIsbn().compareTo(currentNode.getIsbn()) > 0){
            currentNode.right = insertRec(currentNode.right, newBook);
        }
        return currentNode;
    }
    

    // Seacrh by isbn
    public Book searchISBN(String isbn){
        return searchISBN(root, isbn);
    }

    private Book searchISBN(Book root, String isbn){
        if(root == null || root.getIsbn().equals(isbn)){
            return root;
        }
        if(isbn.compareTo(root.getIsbn()) < 0){
            return searchISBN(root.left, isbn);
        }
        return searchISBN(root.right, isbn);
    }


    //Search by title
    public Book searchTitle(String title){
        return searchTitle(root, title);
    }

    private Book searchTitle(Book root, String title){
        if(root == null){
            return null;
        }
        if(root.getTitle().equals(title)){
            return root;
        }

        Book leftSearch = searchTitle(root.left, title);
        if(leftSearch != null){
            return leftSearch;
        }
        return searchTitle(root.right, title);
    }


    //Search by author
    public Book searchAuthor(String author){
        return searchAuthor(root, author);
    }

    private Book searchAuthor(Book root, String author){
        if(root == null){
            return null;
        }
        if(root.getAuthor().equals(author)){
            return root;
        }

        Book leftSearch = searchAuthor(root.left, author);
        if(leftSearch != null){
            return leftSearch;
        }

        return searchAuthor(root.right, author);
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
        }
    }
    
}  