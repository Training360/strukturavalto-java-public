package classstructureconstructors;

public class Store {

    private String product;

    private int stock;

    public Store(String product) {
        this.product = product;
        stock = 0;
    }

    public String getProduct() {
        return product;
    }

    public int getStock() {
        return stock;
    }

    public void store(int amount) {
        stock = stock + amount;
    }

    public void dispatch(int amount) {
        stock = stock - amount;
    }
}
