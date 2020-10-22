package introinheritance.basket;

public class Item {

    private String barcode;
    private double nettoPrice;
    private int vatPercent;

    public Item(String barcode, double nettoPrice, int vatPercent) {
        this.barcode = barcode;
        this.nettoPrice = nettoPrice;
        this.vatPercent = vatPercent;
    }

    public double getTaxAmount() {
        return nettoPrice * (1.0 * vatPercent / 100);
    }

    public double getNettoPrice() {
        return nettoPrice;
    }

    public String getBarcode() {
        return barcode;
    }

    @Override
    public String toString() {
        return "Item{" +
                "barcode='" + barcode + '\'' +
                ", nettoPrice=" + nettoPrice +
                ", vatPercent=" + vatPercent +
                '}';
    }
}
