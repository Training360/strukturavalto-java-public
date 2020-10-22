package introinheritance.basket;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ItemTest {

    @Test
    public void testGetTaxAmount() {
        //Given
        Item item = new Item("123456", 1000, 27);
        //Then
        assertThat(Math.round(item.getTaxAmount()), equalTo(270L));
    }

    @Test
    public void testToString() {
        //Given
        Item item = new Item("123456", 1000, 27);
        //Then
        assertThat(item.toString(), equalTo("Item{barcode='123456', nettoPrice=1000.0, vatPercent=27}"));
    }
}
