package algorithmsmax.sales;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class MaxAlgorithmsTest {

    List<Salesperson> salespersons = Arrays.asList(
            new Salesperson("John", 600, 500),
            new Salesperson("Bill", 200, 300),
            new Salesperson("Kate", 700, 100),
            new Salesperson("Mary", 700, 300),
            new Salesperson("Karl", 200, 50)
    );

    @Test
    public void testSelectSalesPersonWithMaxSalesAmount() {
        SalesAmountMaxSelector maxAmount = new SalesAmountMaxSelector();

        assertThat(maxAmount.selectSalesPersonWithMaxSalesAmount(salespersons).getAmount(), is(700));
        assertThat(maxAmount.selectSalesPersonWithMaxSalesAmount(salespersons).getTarget(), is(100));
    }

    @Test
    public void testSelectSalesPersonWithFurthestAboveTarget() {
        SalespersonWithFurthestAboveTargetSelector aboveTarget = new SalespersonWithFurthestAboveTargetSelector();

        assertThat(aboveTarget.selectSalesPersonWithFurthestAboveTarget(salespersons).getDifferenceFromTarget(), is(600));
        assertThat(aboveTarget.selectSalesPersonWithFurthestAboveTarget(salespersons).getAmount(), is(700));
        assertThat(aboveTarget.selectSalesPersonWithFurthestAboveTarget(salespersons).getTarget(), is(100));
    }

    @Test
    public void testSelectSalesPersonWithFurthestBelowTarget() {
        SalespersonWithFurthestBelowTargetSelector belowTarget = new SalespersonWithFurthestBelowTargetSelector();

        assertThat(belowTarget.selectSalesPersonWithFurthestBelowTarget(salespersons).getDifferenceFromTarget(), is(-100));
        assertThat(belowTarget.selectSalesPersonWithFurthestBelowTarget(salespersons).getAmount(), is(200));
        assertThat(belowTarget.selectSalesPersonWithFurthestBelowTarget(salespersons).getTarget(), is(300));
    }

}
