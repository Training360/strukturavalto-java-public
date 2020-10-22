package classstructureconstructors;

public class Book {

    private String author;

    private String title;

    private String regNumber;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void register(String regNumber) {
        this.regNumber = regNumber;
    }
}
