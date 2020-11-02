package sorting;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class OrderedArrayLibraryTest {

    private List<Book> bookList = new ArrayList<>();

    @BeforeEach
    public void setUp() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("books.csv");
        String line;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
            while ((line = reader.readLine()) != null) {
                String[] lineParts = line.split(";");
                bookList.add(new Book(Integer.parseInt(lineParts[0]), lineParts[1], lineParts[2]));
            }
        } catch (IOException ex) {
            throw new IllegalArgumentException("File not found");
        }
    }

    @Test
    public void testSortingById() {
        //Given
        Collections.shuffle(bookList);
        Book[] bookArray = new Book[bookList.size()];
        OrderedArrayLibrary orderedLibrary = new OrderedArrayLibrary(bookList.toArray(bookArray));
        //When
        Book[] books = orderedLibrary.sortingById();
        //Then
        assertEquals(1001, books[0].getId());
        assertEquals(1172, books[books.length - 1].getId());
    }

    @Test
    public void testSortingByTitle() {
        //Given
        Collections.shuffle(bookList);
        Book[] bookArray = new Book[bookList.size()];
        OrderedArrayLibrary orderedLibrary = new OrderedArrayLibrary(bookList.toArray(bookArray));
        //When
        Book[] books = orderedLibrary.sortingByTitle();
        //Then
        assertEquals("A babó", books[0].getTitle());
        assertEquals("Tolkien", books[0].getAuthor());
        assertEquals("1082 Tolkien A babó", books[0].toString());

        assertEquals("Öreg néne őzikéje", books[books.length - 1].getTitle());
    }

    @Test
    public void equalAndHashCodeTest() {
        Book book = new Book(1082, "J.R.R Tolkien", "The Hobbit");
        Book[] bookArray = new Book[bookList.size()];
        OrderedArrayLibrary orderedLibrary = new OrderedArrayLibrary(bookList.toArray(bookArray));

        Book[] books = orderedLibrary.sortingByTitle();

        assertTrue(books[0].equals(book));
        assertEquals(1082, book.hashCode());
    }
}
