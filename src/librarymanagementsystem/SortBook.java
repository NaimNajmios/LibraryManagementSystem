package librarymanagementsystem;

public class SortBook {

    // Method to sort a linked list using bubble sort
    public static void bubbleSort(BookCollection collection) {
        // bubble sort
        int n = collection.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Swap the nodes
                if (collection.getBookAtNode(j).getTitle().compareTo(collection.getBookAtNode(j + 1).getTitle()) > 0) {
                    Book tempNode = collection.getFirstBook();
                    for (int k = 0; k < j; k++) {
                        tempNode = tempNode.right;
                    }
                    // Update iNode for the next iteration
                    Book nextNode = tempNode.right;
                    // Swap the nodes
                    tempNode.right = nextNode.right;
                    nextNode.right = tempNode;
                }
            }
        }
    }

    // Method to sort a linked list using bubble sort, return book collection
    public static BookCollection collectionBubbleSort(BookCollection collection) {
        bubbleSort(collection);
        return collection;
    }

    // Method to sort a linked list using quick sort
    public static void quickSort(BookCollection collection, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[p] is now at right place
            int pi = partition(collection, low, high);
            // Recursively sort elements before and after partition
            quickSort(collection, low, pi - 1);
            quickSort(collection, pi + 1, high);
        }
    }

    // Partition for quickSort
    private static int partition(BookCollection collection, int low, int high) {
        // pivot
        Book pivotNode = collection.getFirstBook();
        for (int i = 0; i < high; i++) {
            pivotNode = pivotNode.right;
        }
        // iNode
        Book iNode = collection.getFirstBook();
        for (int i = 0; i < low - 1; i++) {
            iNode = iNode.right;
        }
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            Book jNode = collection.getFirstBook();
            for (int k = 0; k < j; k++) {
                jNode = jNode.right;
            }
            // If current element is smaller than or equal to pivot
            if (jNode.getTitle().compareTo(pivotNode.getTitle()) <= 0) {
                i++;
                // Swap the nodes
                Book tempNode = iNode;
                iNode = jNode;
                jNode = tempNode;
                // Update iNode for the next iteration
                iNode = iNode.right;
            }
        }

        // Swap the pivot with the element at index i+1
        Book tempNode = iNode;
        // Update iNode for the next iteration
        iNode = pivotNode;
        // Swap the nodes
        pivotNode = tempNode;
        return i + 1;
    }

    public static void mergeSort(BookCollection collection) {
        mergeSortHelper(collection.getFirstBook());
    }

    /**
     * mergeSortHelper:
     * Recursively divides the linked list into two halves.
     * Sorts each half recursively.
     * Merges the sorted halves using the merge method.
     **/
    private static Book mergeSortHelper(Book head) {
        // base case
        if (head == null || head.right == null) {
            return head;
        }
        // divide
        Book middle = getMiddle(head);
        Book left = head;
        Book right = middle.right;
        middle.right = null;
        // sort
        left = mergeSortHelper(left);
        right = mergeSortHelper(right);
        // merge
        return merge(left, right);
    }

    /**
     * getMiddle:
     * Finds the middle node of the linked list using the slow-fast pointer
     * technique
     */

    private static Book getMiddle(Book head) {
        // base case
        if (head == null) {
            return head;
        }

        // divide
        Book slow = head, fast = head.right;
        while (fast != null && fast.right != null) {
            slow = slow.right;
            fast = fast.right.right;
        }
        return slow;
    }

    /**
     * merge:
     * Creates a dummy node to act as the head of the merged list.
     * Compares the titles of the current nodes in the left and right lists.
     * Adds the node with the smaller title to the merged list.
     * Moves the pointer of the list from which the node was taken.
     * Continues until one of the lists becomes empty.
     * Appends the remaining nodes of the non-empty list to the merged list.
     */

    private static Book merge(Book left, Book right) {
        Book dummyHead = new Book();
        Book tail = dummyHead;

        while (left != null && right != null) {
            if (left.getTitle().compareTo(right.getTitle()) <= 0) {
                tail.right = left;
                left = left.right;
            } else {
                tail.right = right;
                right = right.right;
            }
            tail = tail.right;
        }
        tail.right = left != null ? left : right;
        return dummyHead.right;
    }
}