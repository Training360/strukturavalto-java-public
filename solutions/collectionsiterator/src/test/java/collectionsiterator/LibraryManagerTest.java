package collectionsiterator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LibraryManagerTest {

    private LibraryManager manager;

    @BeforeEach
    public void setup() {
        Set<Book> bookSet = new HashSet<>(Arrays.asList(new Book(1245, "Core Java", "Cay Horstmann"),
                new Book(2454, "Core JavaServer Faces", "Cay Horstmann"),
                new Book(5454, "Effective Java", "Bloch")));
        manager = new LibraryManager(bookSet);
    }


    @Test
    public void missingRegnumberShouldThrowException() throws MissingBookException {

        Exception ex = assertThrows(MissingBookException.class, () -> {
            manager.findBookByRegNumber(1212);
        });
        assertEquals("No books found with regnumber: " + 1212, ex.getMessage());
    }

    @Test
    public void testFindBookByRegNumber() {
        // When
        Book book = manager.findBookByRegNumber(1245);
        //Then
        assertEquals("Cay Horstmann", book.getAuthor());
        assertEquals("Core Java", book.getTitle());
    }

    @Test
    public void missingRegnumberShouldThrowExceptionAtRemove() throws MissingBookException {

        Exception ex = assertThrows(MissingBookException.class, () -> {
            manager.removeBookByRegNumber(1212);

        });
        assertEquals("No books found with regnumber: " + 1212, ex.getMessage());
    }

    @Test
    public void testRemoveBookByRegNumber() {
        // When
        int removedBookId = manager.removeBookByRegNumber(2454);
        //Then
        assertEquals(2454, removedBookId);
        assertEquals(2, manager.libraryBooksCount());
    }

    @Test
    public void nonExistingAuthorShouldThrowExceptionAtRemove() throws MissingBookException {

        Exception ex = assertThrows(MissingBookException.class, () -> {
            manager.selectBooksByAuthor("Tolkien");
        });
        assertEquals("No books found by Tolkien", ex.getMessage());


    }

    @Test
    public void testSelectBooksByAuthor() {
        // When
        Set<Book> foundBooks = manager.selectBooksByAuthor("Cay Horstmann");
        //Then
        assertEquals(2, foundBooks.size());
    }
}
