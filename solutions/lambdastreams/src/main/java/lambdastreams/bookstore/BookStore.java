package lambdastreams.bookstore;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookStore {

    private List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

    public Integer getNumberOfBooks() {
        return books.stream().reduce(0, (a, b) -> a + b.getNumber(), (x, y) -> x + y);
    }

    public Optional<Book> findNewestBook() {
        return books.stream().max((a, b) -> a.getYearOfPublish() - b.getYearOfPublish());
    }

    public int getTotalValue() {
        return books.stream().reduce(0, (a, b) -> a + b.getPrice() * b.getNumber(), (x, y) -> x + y);
    }

    public List<Book> getByYearOfPublish(int year) {
        return books.stream().collect(Collectors.groupingBy(Book::getYearOfPublish)).get(year);
    }
}
