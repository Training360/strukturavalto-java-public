package inheritanceattributes.order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShippedBookTest {

    @Test
    public void constructorAndToStringTest() {
        //Given
        ShippedBook book = new ShippedBook("Gyűrűk ura", 3000, 1200);
        //Then
        assertEquals("Gyűrűk ura:3000 - 1200",book.toString());
    }

    @Test
    public void orderTest()  {
        //Given
        ShippedBook book = new ShippedBook("Gyűrűk ura", 3000, 1200);
        //Then
        assertEquals(7200,book.order(2));
    }

}