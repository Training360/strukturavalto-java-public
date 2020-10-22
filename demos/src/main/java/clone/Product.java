package clone;

public class Product {

    private String name;

    public Product(String name) {
        this.name = name;
    }

    public Product(Product another) {
        this.name = another.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
