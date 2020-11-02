package sorting;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class OrderedLibraryTest {

    private List<Book> bookList = new ArrayList<>();

    @BeforeEach
    public void setUp() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("books.csv");
        String line;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            while ((line = reader.readLine()) != null) {
                String[] lineParts = line.split(";");
                bookList.add(new Book(Integer.parseInt(lineParts[0]), lineParts[1], lineParts[2]));
            }
        } catch (IOException ex) {
            throw new IllegalArgumentException("File not found");
        }
    }


    @Test
    public void emptyCollectionShouldThrowException() throws NullPointerException {
        Exception ex = assertThrows(NullPointerException.class, () -> new OrderedLibrary(new TreeSet<>()).lendFirstBook());
        assertEquals("Libray is empty!", ex.getMessage());
    }

    @Test
    public void testLendFirstBook() {
        // Given
        Collections.shuffle(bookList);
        OrderedLibrary ol = new OrderedLibrary(new TreeSet<>(bookList));
        // When
        Book book = ol.lendFirstBook();
        //Then
        assertEquals(1001, book.getId());
    }
}
