package initalizer;

public class Rate {

    private Currency currency;

    private double conversionFactor;

    public Rate(Currency currency, double conversionFactor) {
        this.currency = currency;
        this.conversionFactor = conversionFactor;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
}
