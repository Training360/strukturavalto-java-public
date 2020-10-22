package introinheritance.basket;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BasketTest {

    private Basket basket;

    @Before
    public void setUp() {
        basket = new Basket();
        basket.addItem(new Item("457812", 1500, 27));
        basket.addItem(new Item("654789", 2500, 0));
    }

    @After
    public void tearDown() {
        basket = null;
    }

    @Test
    public void testAddItem() {
        assertThat(basket.getItems().size(), equalTo(2));
    }

    @Test
    public void testRemoveItem() {
        //When
        basket.removeItem("457812");
        //Then
        assertThat(basket.getItems().size(), equalTo(1));
    }

    @Test
    public void testClearBasket() {
        //When
        basket.clearBasket();
        //Then
        assertThat(basket.getItems().size(), equalTo(0));
    }
}
