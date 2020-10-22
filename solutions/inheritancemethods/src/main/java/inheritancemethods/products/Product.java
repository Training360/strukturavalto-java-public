package inheritancemethods.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

    private String name;
    private BigDecimal unitWeight;
    private int numberOfDecimals;

    public Product(String name, BigDecimal unitWeigth, int numberOfDecimals) {
        this.name = name;
        this.unitWeight = unitWeigth;
        this.numberOfDecimals = numberOfDecimals;
    }

    public Product(String name, BigDecimal unitWeigth) {
        this(name, unitWeigth, 2);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitWeight() {
        return unitWeight;
    }

    public int getNumberOfDecimals() {
        return numberOfDecimals;
    }

    public BigDecimal totalWeight(int pieces) {
        return unitWeight.multiply(new BigDecimal(String.valueOf(pieces))).setScale(numberOfDecimals, RoundingMode.HALF_UP);
    }
}
