package searching;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BookArraySearchTest {

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

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void emptyParametersShouldThrowException() throws IllegalArgumentException {
        // Given
        Book[] bookArray = new Book[bookList.size()];
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Author or title must not be empty!");
        // When
        new BookArraySearch(bookList.toArray(bookArray)).findBookByAuthorTitle("", "");

    }

    @Test
    public void emptyParametersShouldThrowExceptionNull() throws IllegalArgumentException {
        // Given
        Book[] bookArray = new Book[bookList.size()];
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Author or title must not be empty!");
        // When
        new BookArraySearch(bookList.toArray(bookArray)).findBookByAuthorTitle(null, null);

    }

    @Test
    public void notFoundBookShouldThrowException() throws IllegalArgumentException {
        // Given
        String author = "Homérosz";
        String title = "Iliász";
        Book[] bookArray = new Book[bookList.size()];
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("No book found by " + author + " with title " + title);
        // When
        new BookArraySearch(bookList.toArray(bookArray)).findBookByAuthorTitle(author, title);

    }

    @Test
    public void testFindBookByAuthorTitle() {
        //Given
        Book[] bookArray = new Book[bookList.size()];
        BookArraySearch bas = new BookArraySearch(bookList.toArray(bookArray));
        //When
        Book book = bas.findBookByAuthorTitle("Fazekas Anna", "Mackó, mókus, malacka");
        //Then
        assertThat(book.getId(), equalTo(1010));
        assertThat(book.getAuthor(),equalTo(("Fazekas Anna")));
        assertThat(book.getTitle(),equalTo("Mackó, mókus, malacka"));
        assertThat(book.toString(),equalTo("1010 Fazekas Anna Mackó, mókus, malacka"));
    }
}
