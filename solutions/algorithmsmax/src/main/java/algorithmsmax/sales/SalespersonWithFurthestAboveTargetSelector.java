package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {

    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> sales) {
        Salesperson salespersonWithFurthestAboveTarget = null;
        for (Salesperson salesperson : sales) {
            if (salespersonWithFurthestAboveTarget == null
                    || (salesperson.getDifferenceFromTarget() > 0 && salesperson.getDifferenceFromTarget() > salespersonWithFurthestAboveTarget.getDifferenceFromTarget())) {
                salespersonWithFurthestAboveTarget = salesperson;
            }
        }
        return salespersonWithFurthestAboveTarget;
    }
}
