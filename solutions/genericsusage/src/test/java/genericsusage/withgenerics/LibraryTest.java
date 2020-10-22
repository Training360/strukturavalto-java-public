package genericsusage.withgenerics;

import genericsusage.Book;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowExceptionIfArgumentIsNull() {
        exception.expect(NullPointerException.class);

        // When
        new Library().getFirstBook(null);
    }

    @Test
    public void shouldThrowExceptionIfArgumentIsEmptyList() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Argument should not be empty");

        // When
        new Library().getFirstBook(Collections.emptyList());
    }

    @Test
    public void shouldReturnFirst() {
        assertThat(new Library().getFirstBook(Arrays.asList(new Book("Egri Csillagok"))).getTitle(), equalTo("Egri Csillagok"));
    }

}
