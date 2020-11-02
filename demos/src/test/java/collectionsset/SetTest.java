package collectionsset;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {

    @Test
    public void testSet() {
        Set<Trainer> s = new HashSet<>();

        s.add(new Trainer("Jack"));
        s.add(new Trainer("Jack"));

        assertEquals(1, s.size());
        assertEquals(Set.of(new Trainer("Jack")), s);
    }

    @Test
    public void testSetOrder() {
        Set<Trainer> s = new LinkedHashSet<>();

        s.add(new Trainer("Jane"));
        s.add(new Trainer("Jack"));

        assertEquals(Arrays.asList(new Trainer("Jane"), new Trainer("Jack")), new ArrayList<>(s));
    }
}
