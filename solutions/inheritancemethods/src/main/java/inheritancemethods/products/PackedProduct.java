package inheritancemethods.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PackedProduct extends Product {

    private int packingUnit;
    private BigDecimal weightOfBox;

    public PackedProduct(String name, BigDecimal unitWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    public int getPackingUnit() {
        return packingUnit;
    }

    public BigDecimal getWeightOfBox() {
        return weightOfBox;
    }

    @Override
    public BigDecimal totalWeight(int pieces) {
        int numberOfBoxes = pieces % packingUnit == 0 ? pieces / packingUnit : pieces / packingUnit + 1;
        BigDecimal box = weightOfBox.multiply(new BigDecimal(String.valueOf(numberOfBoxes)));

        return super.totalWeight(pieces).add(box).setScale(getNumberOfDecimals(), RoundingMode.HALF_UP);
    }
}
