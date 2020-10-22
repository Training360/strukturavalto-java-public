package filescanner.library;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void testLoadFromFile() {
        Library library = new Library();

        library.loadFromFile();

        assertEquals(4, library.getBooks().size());
        assertEquals("Robert C. Martin", library.getBooks().get(2).getAuthor());
    }
}
