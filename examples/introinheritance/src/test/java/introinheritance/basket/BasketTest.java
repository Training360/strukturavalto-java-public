package introinheritance.basket;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasketTest {

    private Basket basket;

    @BeforeEach
    public void setUp() {
        basket = new Basket();
        basket.addItem(new Item("457812", 1500, 27));
        basket.addItem(new Item("654789", 2500, 0));
    }

    @AfterEach
    public void tearDown() {
        basket = null;
    }

    @Test
    public void testAddItem() {
        assertEquals(2, basket.getItems().size());
    }

    @Test
    public void testRemoveItem() {
        //When
        basket.removeItem("457812");
        //Then
        assertEquals(1, basket.getItems().size());
    }

    @Test
    public void testClearBasket() {
        //When
        basket.clearBasket();
        //Then
        assertEquals(0, basket.getItems().size());
    }
}
