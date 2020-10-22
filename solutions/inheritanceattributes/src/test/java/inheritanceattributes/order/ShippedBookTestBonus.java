package inheritanceattributes.order;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ShippedBookTestBonus {

    @Test
    public void purchaseTest() {
        //Given
        ShippedBook book = new ShippedBook("Gyűrűk ura", 3000, 1200);
        //Then
        assertThat(book.purchase(2), equalTo(6000));
    }
}
