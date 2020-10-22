package collectionsclass;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CollectionManagerTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private List<Book> bookList = new ArrayList<>();

    @Before
    public void setUp() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("books.csv");
        String line;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            while ((line = reader.readLine()) != null) {
                String[] lineParts = line.split(";");
                bookList.add(new Book(Integer.parseInt(lineParts[0]), lineParts[1], lineParts[2]));
            }
        }
    }

    @Test
    public void unmodifiableListShouldThrowExceptionOnAdd() throws UnsupportedOperationException {
        // Given
        CollectionManager cm = new CollectionManager(bookList);
        exception.expect(UnsupportedOperationException.class);
        // When
        cm.createUnmodifiableLibrary().add(new Book(5555, "Douglas Adams", "Hitchhikers Guide"));
    }

    @Test
    public void testReverseLibrary() {
        // Given
        CollectionManager cm = new CollectionManager(bookList);
        // When
        List<Book> bookList = cm.reverseLibrary();
        //Then
        assertThat(bookList.get(0).getId(), equalTo(1172));
        assertThat(bookList.get(bookList.size() - 1).getId(), equalTo(1001));
    }

    @Test
    public void testGetFirstBook() {
        // Given
        CollectionManager cm = new CollectionManager(bookList);
        // When
        Book book = cm.getFirstBook();
        //Then
        assertThat(book.getId(), equalTo(1001));
    }

    @Test
    public void testGetLastBook() {
        // Given
        CollectionManager cm = new CollectionManager(bookList);
        // When
        Book book = cm.getLastBook();
        //Then
        assertThat(book.getId(), equalTo(1172));
        assertThat(book.getTitle(),equalTo("Az elfeledett mackó"));
        assertThat(book.getAuthor(),equalTo("Anna Mangan"));
        assertThat(book.toString(),equalTo("1172 Anna Mangan Az elfeledett mackó"));

    }

    @Test
    public void equalsAndHashCodeTest(){
        Book book1 = new Book(1172,"Anna Morgan","Az elfeledett mackó");
        Book book2 = new Book(1172,"A. Morgan","");


        assertThat(book1.equals(book2),equalTo(true));
        assertThat(book1.hashCode(),equalTo(1172));

    }
}
