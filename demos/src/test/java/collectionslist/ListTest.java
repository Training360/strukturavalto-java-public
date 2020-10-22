package collectionslist;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ListTest {

    @Test
    public void testList() {
        List<String> l = new LinkedList<>();
        l.add("John");
        l.add("Jack");
        assertThat(l, equalTo(Arrays.asList("John", "Jack")));

        Collection<String> c = l;
        c.add("Jane");
        assertThat(c, equalTo(Arrays.asList("John", "Jack", "Jane")));

        c.remove("Jack");
        assertThat(c, equalTo(Arrays.asList("John", "Jane")));

        assertThat(c.isEmpty(), equalTo(false));
        assertThat(c.size(), equalTo(2));

        assertThat(c.contains("Jane"), equalTo(true));
        assertThat(c.contains("Jack"), equalTo(false));

        c.clear();
        assertThat(c.isEmpty(), equalTo(true));

        l.add("John");
        l.add("Jane");
        l.add(0, "Jack");
        assertThat(c, equalTo(Arrays.asList("Jack", "John", "Jane")));

        assertThat(l.get(1), equalTo("John"));
        assertThat(l.indexOf("Jane"), equalTo(2));

        l.add("Jack");
        assertThat(l.indexOf("Jack"), equalTo(0));
        assertThat(l.lastIndexOf("Jack"), equalTo(3));

        l.remove(0);
        assertThat(c, equalTo(Arrays.asList("John", "Jane", "Jack")));

        l.set(1, "Joe");
        assertThat(c, equalTo(Arrays.asList("John", "Joe", "Jack")));
    }
}
