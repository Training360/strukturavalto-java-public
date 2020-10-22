package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestBelowTargetSelector {

    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> sales) {
        Salesperson salespersonWithFurthestBelowTarget = null;
        for (Salesperson salesperson : sales) {
            if (salespersonWithFurthestBelowTarget == null
                    || (salesperson.getDifferenceFromTarget() < 0 && salesperson.getDifferenceFromTarget() < salespersonWithFurthestBelowTarget.getDifferenceFromTarget())) {
                salespersonWithFurthestBelowTarget = salesperson;
            }
        }
        return salespersonWithFurthestBelowTarget;
    }
}
