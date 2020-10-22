package lambdaintermediate;

import java.math.BigDecimal;

public class Coffee {

    private CoffeeType type;

    private BigDecimal price;

    public Coffee(CoffeeType type, BigDecimal price) {
        this.type = type;
        this.price = price;
    }

    public CoffeeType getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
