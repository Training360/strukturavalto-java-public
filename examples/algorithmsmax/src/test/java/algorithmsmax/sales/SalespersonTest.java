package algorithmsmax.sales;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalespersonTest {

    @Test
    public void testCreateIsOk() {
        Salesperson person = new Salesperson("Somebody", 1000, 200);

        assertEquals(1000, person.getAmount());
        assertEquals(200, person.getTarget());
        assertEquals(800, person.getDifferenceFromTarget());
    }

}
