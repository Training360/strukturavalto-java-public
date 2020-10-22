package genericsusage.withgenerics;


import genericsusage.Book;

import java.util.List;

public class Library {

    public Book getFirstBook(List<Book> books) {
        if (books == null) {
            throw new NullPointerException("Argument should not be null!");
        }
        if (books.isEmpty()) {
            throw new IllegalArgumentException("Argument should not be empty!");
        }
        return books.get(0);
    }

}
