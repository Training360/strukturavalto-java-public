package collectionscomp;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class OrderedLibraryTest {

    private OrderedLibrary library;


    @Before
    public void setUp() {
        List<Book> bookList = new LinkedList<>(Arrays.asList(new Book(1245, "Őrület", "Utasy Kristóf"),
                new Book(2454, "Álom", "Ómolnár Géza"),
                new Book(5454, "Államhatár", "Ákos János"),
                new Book(5454, "Utitársak", "Ős János")));

        library = new OrderedLibrary(bookList);
    }

    @Test
    public void testOrderedByTitle() {
        // Given
        List<Book> orderedBookList = library.orderedByTitle();
        //Then
        assertThat(orderedBookList.get(0).getTitle(), equalTo("Utitársak"));
    }

    @Test
    public void testOrderedByAuthor() {
        // Given
        List<Book> orderedBookList = library.orderedByAuthor();
        //Then
        assertThat(orderedBookList.get(0).getAuthor(), equalTo("Utasy Kristóf"));
    }

    @Test
    public void testOrderedByTitleLocale() {
        // Given
        List<String> orderedTitleList = library.orderedByTitleLocale(new Locale("hu", "HU"));
        //Then
        assertThat(orderedTitleList.get(0), equalTo("Államhatár"));
    }
}
