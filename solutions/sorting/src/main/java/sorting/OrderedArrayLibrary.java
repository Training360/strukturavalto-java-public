package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class OrderedArrayLibrary {

    private Book[] bookArray;

    public OrderedArrayLibrary(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book[] sortingById(){
        Book[] books = new Book[bookArray.length];
        System.arraycopy(bookArray, 0, books, 0, bookArray.length);
        Arrays.sort(books);
        return books;
    }

    public Book[] sortingByTitle() {
        Comparator<Book> titleComparator = new Comparator<Book>() {

            public int compare(Book bookA, Book bookB) {
                return bookA.getTitle().compareTo(bookB.getTitle());
            }
        };

        Book[] books = new Book[bookArray.length];
        System.arraycopy(bookArray, 0, books, 0, bookArray.length);
        Arrays.sort(books, titleComparator);
        return books;
    }
}
