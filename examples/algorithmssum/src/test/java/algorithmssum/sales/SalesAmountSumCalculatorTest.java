package algorithmssum.sales;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class SalesAmountSumCalculatorTest {

    @Test
    public void testSumSalesAmount() {
        SalesAmountSumCalculator test = new SalesAmountSumCalculator();

        List<Salesperson> salespersons = Arrays.asList(
                new Salesperson("John", 600),
                new Salesperson("Bill", 200),
                new Salesperson("Kate", 700),
                new Salesperson("Mary", 700),
                new Salesperson("Karl", 200)
        );

        assertThat(test.sumSalesAmount(salespersons), is(2400));

    }

}
