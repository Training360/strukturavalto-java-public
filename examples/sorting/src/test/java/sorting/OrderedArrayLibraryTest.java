package sorting;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class OrderedArrayLibraryTest {

    private List<Book> bookList = new ArrayList<>();

    @Before
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
        assertThat(books[0].getId(), equalTo(1001));
        assertThat(books[books.length - 1].getId(), equalTo(1172));
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
        assertThat(books[0].getTitle(), equalTo("A babó"));
        assertThat(books[0].getAuthor(),equalTo("Tolkien "));
        assertThat(books[0].toString(),equalTo("1082 Tolkien  A babó"));

        assertThat(books[books.length - 1].getTitle(), equalTo("Öreg néne őzikéje"));
    }

    @Test
    public void equalAndHashCodeTest(){
        Book book = new Book(1082,"J.R.R Tolkien","The Hobbit");
        Book[] bookArray = new Book[bookList.size()];
        OrderedArrayLibrary orderedLibrary = new OrderedArrayLibrary(bookList.toArray(bookArray));

        Book[] books = orderedLibrary.sortingByTitle();

        assertThat(books[0].equals(book),equalTo(true));
        assertThat(book.hashCode(),equalTo(1082));
    }
}
