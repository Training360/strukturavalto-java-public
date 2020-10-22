package clone;

import java.time.LocalDateTime;

public class Auction  {

    private int price;

    private LocalDateTime start;

    private User user;

    private Product product;

    public Auction(int price, LocalDateTime start, User user, Product product) {
        this.price = price;
        this.start = start;
        this.user = user;
        this.product = product;
    }

    public Auction(Auction another) {
        price = another.price;
        start = another.start;
        user = another.user;
        product = new Product(another.product);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
