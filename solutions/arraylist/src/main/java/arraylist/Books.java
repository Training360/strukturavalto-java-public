package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books {

    private List<String> titles = new ArrayList<>();

    public void add(String title) {
        titles.add(title);
    }

    public void removeByPrefix(String prefix) {
        List<String> toDelete = new ArrayList<>();
        for (String title : titles) {
            if (title.startsWith(prefix)) {
                toDelete.add(title);
            }
        }
        titles.removeAll(toDelete);
    }

    public List<String> findAllByPrefix(String prefix) {
        List<String> found = new ArrayList<>();
        for (String title : titles) {
            if (title.startsWith(prefix)) {
                found.add(title);
            }
        }
        return found;
    }

    public List<String> getTitles() {
        return titles;
    }

    public static void main(String[] args) {
        Books books = new Books();
        books.add("Antigoné");
        books.add("Egri csillagok");
        books.add("A kis herceg");
        books.add("Egri csillagok");

        System.out.println(books.getTitles());

        System.out.println(books.findAllByPrefix("Egri"));

        books.removeByPrefix("Egri");
        System.out.println(books.getTitles());
    }
}
