package collectionsiterator;

public class Book {

    private int regNumber;
    private String title;
    private String author;

    public Book(int regNumber, String title, String author) {
        this(title, author);
        this.regNumber = regNumber;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

}
