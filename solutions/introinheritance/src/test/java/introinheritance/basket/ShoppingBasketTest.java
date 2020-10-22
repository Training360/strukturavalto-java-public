package introinheritance.basket;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ShoppingBasketTest {

    private ShoppingBasket shoppingBasket;

    @Before
    public void setUp() {
        shoppingBasket = new ShoppingBasket();
        shoppingBasket.addItem(new Item("123456", 1500, 27));
        shoppingBasket.addItem(new Item("789456", 2500, 0));
        shoppingBasket.addItem(new Item("147258", 5000, 27));
    }

    @After
    public void tearDown() {
        shoppingBasket = null;
    }

    @Test
    public void testAddItem() {
        assertThat(Math.round(shoppingBasket.sumNettoPrice()), equalTo(9000L));
    }

    @Test
    public void testRemoveItem() {
        // When
        shoppingBasket.removeItem("123456");
        //Then
        assertThat(Math.round(shoppingBasket.sumNettoPrice()), equalTo(7500L));
    }

    @Test
    public void testSumNettoPrice() {

        assertThat(shoppingBasket.sumNettoPrice(), equalTo(9000.0));
    }

    @Test
    public void testSumTaxValue() {

        assertThat(shoppingBasket.sumTaxValue(), equalTo(1755.0));
    }

    @Test
    public void testSumBruttoPrice() {

        assertThat(shoppingBasket.sumBruttoPrice(), equalTo(10755.0));
    }

    @Test
    public void testCheckout() {
        //When
        shoppingBasket.checkout();
        //Then
        assertThat(shoppingBasket.sumNettoPrice(), equalTo(0.0));
    }

    @Test
    public void testRemoveMostExpensiveItem() {
        // When
        shoppingBasket.removeMostExpensiveItem();
        //Then
        assertThat(shoppingBasket.sumNettoPrice(), equalTo(4000.0));
    }
}
