package algorithmsmax.sales;

import java.util.List;

public class SalesAmountMaxSelector {

    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> sales) {
        Salesperson salespersonWithMaxSalesAmount = null;
        for (Salesperson salesperson : sales) {
            if (salespersonWithMaxSalesAmount == null || salesperson.getAmount() > salespersonWithMaxSalesAmount.getAmount()) {
                salespersonWithMaxSalesAmount = salesperson;
            }
        }
        return salespersonWithMaxSalesAmount;
    }
}
