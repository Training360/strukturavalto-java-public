package inheritanceattributes.order;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ShippedBookTest {

    @Test
    public void constructorAndToStringTest() {
        //Given
        ShippedBook book = new ShippedBook("Gyűrűk ura", 3000, 1200);
        //Then
        assertThat(book.toString(), equalTo("Gyűrűk ura:3000 - 1200"));
    }

    @Test
    public void orderTest()  {
        //Given
        ShippedBook book = new ShippedBook("Gyűrűk ura", 3000, 1200);
        //Then
        assertThat(book.order(2), equalTo(7200));
    }

}