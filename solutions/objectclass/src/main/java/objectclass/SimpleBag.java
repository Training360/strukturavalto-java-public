package objectclass;

import java.util.ArrayList;
import java.util.List;

public class SimpleBag {

    List<Object> items = new ArrayList<>();

    int cursor = -1;

    public SimpleBag() {
        beforeFirst();
    }

    public void putItem(Object item) {
        items.add(item);
    }

    public boolean isEmpty() {
        return items.size() == 0;
    }

    public int size() {
        return items.size();
    }

    public void beforeFirst() {
        cursor = -1;
    }

    public boolean hasNext() {
        return !(isEmpty() || cursor >= items.size() - 1);
    }

    public Object next() {
        cursor++;
        return items.get(cursor);
    }

    public boolean contains(Object item) {
        return items.contains(item);
    }

    public int getCursor() {
        return cursor;
    }
}
