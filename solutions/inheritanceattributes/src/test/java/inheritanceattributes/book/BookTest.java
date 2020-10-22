package inheritanceattributes.book;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BookTest {

    @Test
    public void constructorTest() {
        //Given
        Book book = new Book("Gyűrűk ura", 3000);
        //Then
        assertThat(book.getTitle(), equalTo("Gyűrűk ura"));
        assertThat(book.price, equalTo(3000));
    }

    @Test
    public void testPurchase() {
        //Given
        Book book = new Book("Gyűrűk ura", 3000);
        //Then
        assertThat(book.purchase(2), equalTo(6000));
    }
}