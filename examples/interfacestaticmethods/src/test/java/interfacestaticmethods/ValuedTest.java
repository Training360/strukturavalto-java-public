package interfacestaticmethods;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ValuedTest {

    @Test
    public void testSum() {

        List<Valued> items = List.of(new Product("apple", 0.5),
                new Product("book", 2.1),
                new Product("printer", 18.9));

        assertEquals(0.000001, 21.5, Valued.totalValue(items));
    }
}
