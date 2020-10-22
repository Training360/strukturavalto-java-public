package finalmodifier;

public class TaxCalculator {

    public static final double PERCENT = 27;

    public double tax(double price) {
        return price * PERCENT / 100;
    }

    public double priceWithTax(double price) {
        return price * (1 + PERCENT / 100);
    }

    public static void main(String[] args) {
        System.out.println(new TaxCalculator().tax(1000));
        System.out.println(new TaxCalculator().priceWithTax(1000));
    }
}
