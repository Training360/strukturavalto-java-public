package collectionsequalshash;


import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookCatalogTest {

    private static final Book[] books = new Book[]{
            new Book("1212", "Egri Csillagok", "Gárdonyi Géza"),
            new Book("2121", "Vuk", "Fekete István"),
            new Book("4545", "Rab Ráby", "Jókai Mór")
    };

    @Test
    public void findSelectedBookInBookList() {
        //When
        Book foundBook = new BookCatalog().findBookByTitleAuthor(Arrays.asList(books),"Vuk", "Fekete István");
        //Then
        assertThat(foundBook.getRegNumber(),equalTo("2121"));
        assertThat(foundBook.getAuthor(),equalTo("Fekete István"));
        assertThat(foundBook.getTitle(),equalTo("Vuk"));
        assertThat(foundBook.toString(), equalTo("Book{regNumber='2121', title='Vuk', author='Fekete István'}"));
    }

    @Test
    public void bookIsNotInBookList(){
        Book foundBook = new BookCatalog().findBookByTitleAuthor(Arrays.asList(books),"Vuk", "");

        assertThat(foundBook,equalTo(null));
    }

    @Test
    public void findSelectedBookInSearchableBookList() {
        //Given
        Book searchingFor = new Book("2121", "Vuk", "Fekete István");
        //When
        Book foundBook = new BookCatalog().findBook(Arrays.asList(books), searchingFor);
        //Then
        assertThat(searchingFor.equals(foundBook), is(true));
    }

    @Test
    public void selectedBookIsNotInBookList(){
        Book searchingFor = new Book("2121", "Vuk", "István");

        Book foundBook = new BookCatalog().findBook(Arrays.asList(books), searchingFor);

        assertThat(foundBook,equalTo(null));
    }

    @Test
    public void findBookByTitleAndAuthor() {
        //Given
        Book searchingFor = new Book("Vuk", "Fekete István");
        //When
        Book foundBook = new BookCatalog().findBook(Arrays.asList(books), searchingFor);
        //Then
        assertThat(searchingFor.equals(foundBook), is(true));
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
        assertThat(bookSet.size(), equalTo(1));
    }
}
