package lambdastreams.bookstore;

public class Book {

    private String title;

    private int yearOfPublish;

    private int price;

    private int number;

    public Book(String title, int yearOfPublish, int price, int number) {
        this.title = title;
        this.yearOfPublish = yearOfPublish;
        this.price = price;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }
}
