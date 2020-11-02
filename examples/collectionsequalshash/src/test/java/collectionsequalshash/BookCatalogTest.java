package collectionsequalshash;


import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BookCatalogTest {

    private static final Book[] books = new Book[]{
            new Book("1212", "Egri Csillagok", "Gárdonyi Géza"),
            new Book("2121", "Vuk", "Fekete István"),
            new Book("4545", "Rab Ráby", "Jókai Mór")
    };

    @Test
    public void findSelectedBookInBookList() {
        //When
        Book foundBook = new BookCatalog().findBookByTitleAuthor(Arrays.asList(books), "Vuk", "Fekete István");
        //Then
        assertEquals("2121", foundBook.getRegNumber());
        assertEquals("Fekete István", foundBook.getAuthor());
        assertEquals("Vuk", foundBook.getTitle());
        assertEquals("Book{regNumber='2121', title='Vuk', author='Fekete István'}", foundBook.toString());
    }

    @Test
    public void bookIsNotInBookList() {
        Book foundBook = new BookCatalog().findBookByTitleAuthor(Arrays.asList(books), "Vuk", "");

        assertEquals(null, foundBook);
    }

    @Test
    public void findSelectedBookInSearchableBookList() {
        //Given
        Book searchingFor = new Book("2121", "Vuk", "Fekete István");
        //When
        Book foundBook = new BookCatalog().findBook(Arrays.asList(books), searchingFor);
        //Then
        assertTrue(searchingFor.equals(foundBook));
    }

    @Test
    public void selectedBookIsNotInBookList() {
        Book searchingFor = new Book("2121", "Vuk", "István");

        Book foundBook = new BookCatalog().findBook(Arrays.asList(books), searchingFor);

        assertEquals(null, foundBook);
    }

    @Test
    public void findBookByTitleAndAuthor() {
        //Given
        Book searchingFor = new Book("Vuk", "Fekete István");
        //When
        Book foundBook = new BookCatalog().findBook(Arrays.asList(books), searchingFor);
        //Then
        assertTrue(searchingFor.equals(foundBook));
    }

    @Test
    public void addSameBooksToSet() {
        //Given
        Book[] sameBooks = new Book[]{
                new Book("1212", "Egri Csillagok", "Gárdonyi Géza"),
                new Book("1212", "Egri Csillagok", "Gárdonyi Géza"),
                new Book("1212", "Egri Csillagok", "Gárdonyi Géza")
        };
        //When
        Set<Book> bookSet = new BookCatalog().addBooksToSet(sameBooks);
        //Then
        assertEquals(1, bookSet.size());
    }
}
