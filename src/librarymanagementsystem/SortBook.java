package librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;
/*
Quick Sort will sort by ISBN
Bubble Sort will sort by Author
Merge Sort should sort by Title (failed)
*/

public class SortBook {

    public void quickSort(List<Book> books, int low, int high) {
        if (low < high) {
            int pi = partition(books, low, high);

            quickSort(books, low, pi - 1);
            quickSort(books, pi + 1, high);
        }
    }
    
    
    private int partition(List<Book> books, int low, int high) {
        String pivot = books.get(high).getIsbn();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (books.get(j).getIsbn().compareTo(pivot) <= 0) {
                i++;

                // Swap arr[i] and arr[j]
                Book temp = books.get(i);
                books.set(i, books.get(j));
                books.set(j, temp);
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        Book temp = books.get(i + 1);
        books.set(i + 1, books.get(high));
        books.set(high, temp);

        return i + 1;
    }

    public void bubbleSort(List<Book> books) {
    int n = books.size();
    boolean swapped;
    for (int i = 0; i < n - 1; i++) {
        swapped = false;
        for (int j = 0; j < n - i - 1; j++) {
            if (books.get(j).getAuthor().compareTo(books.get(j + 1).getIsbn()) > 0) {
                // Swap arr[j] and arr[j+1]
                Book temp = books.get(j);
                books.set(j, books.get(j + 1));
                books.set(j + 1, temp);
                swapped = true;
            }
        }

        // If no two elements were swapped by inner loop, then break
        if (!swapped)
            break;
    }
}
    
    public void mergeSort(List<Book> books) {
        mergeSortHelper(books, 0, books.size() - 1);
    }

    private void mergeSortHelper(List<Book> books, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSortHelper(books, left, mid);
            mergeSortHelper(books, mid + 1, right);

            merge(books, left, mid, right);
        }
    }

    private void merge(List<Book> books, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        List<Book> leftArray = new ArrayList<>(n1);
        List<Book> rightArray = new ArrayList<>(n2);

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i)
            leftArray.add(books.get(left + i));
        for (int j = 0; j < n2; ++j)
            rightArray.add(books.get(mid + 1 + j));

        // Merge the temporary arrays back into books[left..right]
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray.get(i).getTitle().compareTo(rightArray.get(j).getTitle()) <= 0) {
                books.set(k, leftArray.get(i));
                i++;
            } else {
                books.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }

        // Copy the remaining elements of left[], if there are any
        while (i < n1) {
            books.set(k, leftArray.get(i));
            i++;
            k++;
        }

        // Copy the remaining elements of right[], if there are any
        while (j < n2) {
            books.set(k, rightArray.get(j));
            j++;
            k++;
        }
    }
}