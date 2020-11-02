package inheritanceattributes.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    @Test
    public void constructorTest() {
        //Given
        Book book = new Book("Gyűrűk ura", 3000);
        //Then
        assertEquals("Gyűrűk ura",book.getTitle());
        assertEquals(3000,book.price);
    }

    @Test
    public void testPurchase() {
        //Given
        Book book = new Book("Gyűrűk ura", 3000);
        //Then
        assertEquals(6000,book.purchase(2));
    }
}