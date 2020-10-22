package algorithmsmax.sales;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class SalespersonTest {

    @Test
    public void testCreateIsOk() {
        Salesperson person = new Salesperson("Somebody", 1000, 200);

        assertThat(person.getAmount(), is(1000));
        assertThat(person.getTarget(), is(200));
        assertThat(person.getDifferenceFromTarget(), is(800));
    }

}
