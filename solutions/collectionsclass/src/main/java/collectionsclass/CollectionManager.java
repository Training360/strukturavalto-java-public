package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionManager {

    List<Book> library = new ArrayList<>();

    public CollectionManager(List<Book> library) {
        this.library = library;
    }

    public List<Book> createUnmodifiableLibrary() {
        return Collections.unmodifiableList(this.library);
    }

    public List<Book> reverseLibrary() {
        List<Book> reverseList = new ArrayList<>(library);
        Collections.sort(reverseList);
        Collections.reverse(reverseList);
        return reverseList;
    }

    public Book getFirstBook() {
        return Collections.min(library);
    }

    public Book getLastBook() {
        return Collections.max(library);
    }
}
