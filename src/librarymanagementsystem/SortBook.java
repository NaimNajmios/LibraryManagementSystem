package librarymanagementsystem;
public class SortBook {
    
    //bubble sort
    public static void bubbleSort(BookCollection collection) {
    int n = collection.getSize();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (collection.getBookAtNode(j).getTitle().compareTo(collection.getBookAtNode(j + 1).getTitle()) > 0) {
                    // Swap the nodes
                    Node tempNode = collection.head;
                    for (int k = 0; k < j; k++) {
                        tempNode = tempNode.next;
                    }

                    Node nextNode = tempNode.next;

                    tempNode.next = nextNode.next;
                    nextNode.next = tempNode;
                }
            }
        }
    }
    
    //quickSort
    public static void quickSort(BookCollection collection, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[p] is now at right place 
            int pi = partition(collection, low, high);

            // Recursively sort elements before and after partition 
            quickSort(collection, low, pi - 1);
            quickSort(collection, pi + 1, high);
        }
    }
    
    //partition for quickSort
    private static int partition(BookCollection collection, int low, int high) {
            Node pivotNode = collection.head;
            for (int i = 0; i < high; i++) {
                pivotNode = pivotNode.next;
            }

            Node iNode = collection.head;
            for (int i = 0; i < low - 1; i++) {
                iNode = iNode.next;
            }

            int i = low - 1;
            for (int j = low; j <= high - 1; j++) {
                Node jNode = collection.head;
                for (int k = 0; k < j; k++) {
                    jNode = jNode.next;
                }

                if (jNode.book.getTitle().compareTo(pivotNode.book.getTitle()) <= 0) {
                    i++;

                    // Swap the nodes
                    Node tempNode = iNode;
                    iNode = jNode;
                    jNode = tempNode;

                    // Update iNode for the next iteration
                    iNode = iNode.next;
                }
            }

            // Swap the pivot with the element at index i+1
            Node tempNode = iNode;
            iNode = pivotNode;
            pivotNode = tempNode;

            return i + 1;
        }

    public static void mergeSort(BookCollection collection) {
        mergeSortHelper(collection.head);
    }

/**    mergeSortHelper:
          Recursively divides the linked list into two halves.
          Sorts each half recursively.
          Merges the sorted halves using the merge method. **/
    private static Node mergeSortHelper(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node left = head;
        Node right = middle.next;
        middle.next = null;

        left = mergeSortHelper(left);
        right = mergeSortHelper(right);

        return merge(left, right);
    }
    
/**
getMiddle:
Finds the middle node of the linked list using the slow-fast pointer technique
 */
    private static Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }

        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
    merge:
        Creates a dummy node to act as the head of the merged list.
        Compares the titles of the current nodes in the left and right lists.
        Adds the node with the smaller title to the merged list.
        Moves the pointer of the list from which the node was taken.
        Continues until one of the lists becomes empty.
        Appends the remaining nodes of the non-empty list to the merged list.
     */
    private static Node merge(Node left, Node right) {
        Node dummyHead = new Node(null);
        Node tail = dummyHead;

        while (left != null && right != null) {
            if (left.book.getTitle().compareTo(right.book.getTitle()) <= 0) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        tail.next = left != null ? left : right;

        return dummyHead.next;
    }
}

