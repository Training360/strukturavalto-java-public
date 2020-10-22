package lambdastreams.bookstore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BookStoreTest {

    List<Book> books;

    @Before
    public void initializeList(){
        books = new ArrayList<>();
        books.add(new Book("Learn Java in 24 hours", 2014, 3800, 22));
        books.add(new Book("Spring in Action", 2017, 5700, 10));
        books.add(new Book("Effective Java", 2017, 4500, 16));
        books.add(new Book("Java in a Nutshell", 2009, 9500, 31));
        books.add(new Book("Java Cookbook", 2014, 9200, 4));
    }

    @After
    public void destroyList(){
        books = null;
    }

    @Test
    public void getNumberOfBooks(){
        BookStore bookStore = new BookStore(books);

        assertThat(bookStore.getNumberOfBooks(), equalTo(83));
    }

    @Test
    public void getNumberOfBooksForEmptyList(){
        BookStore bookStore = new BookStore(Collections.emptyList());

        assertThat(bookStore.getNumberOfBooks(), equalTo(0));
    }

    @Test
    public void findNewestBook(){
        BookStore bookStore = new BookStore(books);

        assertThat(bookStore.findNewestBook().get().getYearOfPublish(), equalTo(2017));
    }

    @Test
    public void findNewestBookForEmptyList(){
        BookStore bookStore = new BookStore(Collections.emptyList());

        assertThat(bookStore.findNewestBook(), equalTo(Optional.empty()));
    }

    @Test
    public void getTotalValue() {
        BookStore bookStore = new BookStore(books);

        assertThat(bookStore.getTotalValue(), equalTo(543_900));
    }

    @Test
    public void getTotalValueForEmptyList() {
        BookStore bookStore = new BookStore(Collections.emptyList());

        assertThat(bookStore.getTotalValue(), equalTo(0));
    }

    @Test
    public void getByYearOfPublish(){
        BookStore bookStore = new BookStore(books);

        assertThat(bookStore.getByYearOfPublish(2017).size(), equalTo(2));
        assertThat(bookStore.getByYearOfPublish(2017).get(0).getPrice(), equalTo(5700));
    }

    @Test
    public void getByYearOfPublishMissingYear(){
        BookStore bookStore = new BookStore(books);

        assertThat(bookStore.getByYearOfPublish(2007), equalTo(null));
    }

    @Test
    public void getByYearOfPublishForEmptyList(){
        BookStore bookStore = new BookStore(Collections.emptyList());

        assertThat(bookStore.getByYearOfPublish(2007), equalTo(null));
    }
}
