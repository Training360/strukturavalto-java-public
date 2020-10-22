package interfacestaticmethods;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ValuedTest {

    @Test
    public void testSum() {

        List<Valued> items = List.of(new Product("apple", 0.5),
            new Product("book", 2.1),
            new Product("printer", 18.9));

        assertEquals(21.5, Valued.totalValue(items), 0.000001);
    }
}
