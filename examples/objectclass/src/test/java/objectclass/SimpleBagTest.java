package objectclass;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class SimpleBagTest {

    @Test
    public void testConstructor() {
        //Given
        SimpleBag bag = new SimpleBag();
        //Then
        assertThat(bag.isEmpty(), is(true));
        assertThat(bag.size(), equalTo(0));
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
        assertThat(bag.isEmpty(),equalTo(false));
        assertThat(bag.size(), equalTo(3));

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
            assertThat(bag.next().getClass().toString(), containsString("objectclass.B"));
        }
        assertThat(bag.getCursor(), equalTo(2));
    }

    @Test
    public void testContains() {
        //Given
        SimpleBag bag = new SimpleBag();
        //When
        bag.putItem(new Beer("Borsodi", 239));
        bag.putItem(new Book("Rejtő Jenő", "Az ellopott cirkáló"));
        //Then
        assertThat(bag.contains(new Beer("Borsodi", 239)), is(true));
        assertThat(bag.contains(new Book("Rejtő Jenő", "Az ellopott cirkáló")), is(true));
        assertThat(bag.contains(new Book("Rejtő Jenő", "A megkerült cirkáló")), is(false));
    }
}