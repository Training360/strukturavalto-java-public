package collectionsiterator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LibraryManagerTest {

    private LibraryManager manager;

    @Before
    public void setup() {
        Set<Book> bookSet = new HashSet<>(Arrays.asList(new Book(1245, "Core Java", "Cay Horstmann"),
                new Book(2454, "Core JavaServer Faces", "Cay Horstmann"),
                new Book(5454, "Effective Java", "Bloch")));
        manager = new LibraryManager(bookSet);
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void missingRegnumberShouldThrowException() throws MissingBookException {
        // Given
        exception.expect(MissingBookException.class);
        exception.expectMessage("No books found with regnumber:");
        // When
        manager.findBookByRegNumber(1212);
    }

    @Test
    public void testFindBookByRegNumber() {
        // When
        Book book = manager.findBookByRegNumber(1245);
        //Then
        assertThat(book.getAuthor(), equalTo("Cay Horstmann"));
        assertThat(book.getTitle(),equalTo("Core Java"));
    }

    @Test
    public void missingRegnumberShouldThrowExceptionAtRemove() throws MissingBookException {
        // Given
        exception.expect(MissingBookException.class);
        exception.expectMessage("No books found with regnumber:");
        // When
        manager.removeBookByRegNumber(1212);
    }

    @Test
    public void testRemoveBookByRegNumber() {
        // When
        int removedBookId = manager.removeBookByRegNumber(2454);
        //Then
        assertThat(removedBookId, equalTo(2454));
        assertThat(manager.libraryBooksCount(), equalTo(2));
    }

    @Test
    public void nonExistingAuthorShouldThrowExceptionAtRemove() throws MissingBookException {
        // Given
        exception.expect(MissingBookException.class);
        exception.expectMessage("No books found by");
        // When
        manager.selectBooksByAuthor("Tolkien");
    }

    @Test
    public void testSelectBooksByAuthor() {
        // When
        Set<Book> foundBooks = manager.selectBooksByAuthor("Cay Horstmann");
        //Then
        assertThat(foundBooks.size(), equalTo(2));
    }
}
