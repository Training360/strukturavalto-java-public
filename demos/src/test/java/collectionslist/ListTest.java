package collectionslist;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ListTest {

    @Test
    public void testList() {
        List<String> l = new LinkedList<>();
        l.add("John");
        l.add("Jack");
        assertEquals(Arrays.asList("John", "Jack"), l);

        Collection<String> c = l;
        c.add("Jane");
        assertEquals(Arrays.asList("John", "Jack", "Jane"), c);

        c.remove("Jack");
        assertEquals(Arrays.asList("John", "Jane"), c);

        assertFalse(c.isEmpty());
        assertEquals(2, c.size());

        assertTrue(c.contains("Jane"));
        assertFalse(c.contains("Jack"));

        c.clear();
        assertTrue(c.isEmpty());

        l.add("John");
        l.add("Jane");
        l.add(0, "Jack");
        assertEquals(Arrays.asList("Jack", "John", "Jane"), c);

        assertEquals("John", l.get(1));
        assertEquals(2, l.indexOf("Jane"));

        l.add("Jack");
        assertEquals(0, l.indexOf("Jack"));
        assertEquals(3, l.lastIndexOf("Jack"));

        l.remove(0);
        assertEquals(Arrays.asList("John", "Jane", "Jack"), c);

        l.set(1, "Joe");
        assertEquals(Arrays.asList("John", "Joe", "Jack"), c);
    }
}
