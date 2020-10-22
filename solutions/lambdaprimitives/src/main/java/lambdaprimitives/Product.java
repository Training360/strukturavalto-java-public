package lambdaprimitives;

public class Product {

    private String name;
    private double price;
    private int pieces;

    public Product(String name, double price, int pieces) {
        this.name = name;
        this.price = price;
        this.pieces = pieces;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getPieces() {
        return pieces;
    }
}
