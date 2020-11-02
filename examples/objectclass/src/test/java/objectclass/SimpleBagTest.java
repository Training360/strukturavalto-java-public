package objectclass;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleBagTest {

    @Test
    public void testConstructor() {
        //Given
        SimpleBag bag = new SimpleBag();
        //Then
        assertTrue(bag.isEmpty());
        assertEquals(0, bag.size());
    }


    @Test
    public void testPut() {
        //Given
        SimpleBag bag = new SimpleBag();
        //When
        bag.putItem("alma");
        bag.putItem((new Book("Rejtő Jenő", "Az ellopott cirkáló")));
        bag.putItem(new Beer("Borsodi", 239));
        //Then
        assertFalse(bag.isEmpty());
        assertEquals(3, bag.size());

    }

    @Test
    public void testIteration() {
        //Given
        SimpleBag bag = new SimpleBag();
        //When
        bag.putItem(new Beer("Heineken", 250));
        bag.putItem(new Book("Rejtő Jenő", "Az ellopott cirkáló"));
        bag.putItem(new Beer("Borsodi", 239));
        //Then
        while (bag.hasNext()) {
            assertTrue(bag.next().getClass().toString().contains("objectclass.B"));
        }
        assertEquals(2, bag.getCursor());
    }

    @Test
    public void testContains() {
        //Given
        SimpleBag bag = new SimpleBag();
        //When
        bag.putItem(new Beer("Borsodi", 239));
        bag.putItem(new Book("Rejtő Jenő", "Az ellopott cirkáló"));
        //Then
        assertTrue(bag.contains(new Beer("Borsodi", 239)));
        assertTrue(bag.contains(new Book("Rejtő Jenő", "Az ellopott cirkáló")));
        assertFalse(bag.contains(new Book("Rejtő Jenő", "A megkerült cirkáló")));
    }
}