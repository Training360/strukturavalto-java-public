package algorithmssum.sales;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class SalespersonTest {

    @Test
    public void testCreateSalesperson() {
        Salesperson salesperson = new Salesperson("Jack", 1500);
        assertThat(salesperson.getName(), equalTo("Jack"));
        assertThat(salesperson.getAmount(), is(1500));
    }

}
