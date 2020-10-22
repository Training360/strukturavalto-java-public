package filescanner.library;

public class Book {

    private String regNum;

    private String author;

    private String title;

    private int yearOfPublish;

    public Book(String regNum, String author, String title, int yearOfPublish) {
        this.regNum = regNum;
        this.author = author;
        this.title = title;
        this.yearOfPublish = yearOfPublish;
    }

    public String getRegNum() {
        return regNum;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }
}
