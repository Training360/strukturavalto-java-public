package collectionsclass;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsTest {

    @Test
    public void testCollections() {
        List<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        List<Integer> l = Collections.unmodifiableList(elements);
        assertEquals(Arrays.asList(1, 2), l);

        elements.add(3);
        assertEquals(Arrays.asList(1, 2, 3), l);
    }

    @Test
    public void testReverse() {
        List<Integer> l = Arrays.asList(1, 2, 3, 4);
        Collections.reverse(l);
        assertEquals(Arrays.asList(4, 3, 2, 1), l);
    }

    @Test
    public void testShuffle() {
        List<Integer> l = Arrays.asList(1, 2, 3, 4);
        Random random = new Random(5);
        Collections.shuffle(l, random);
        assertEquals(Arrays.asList(4, 1, 2, 3), l);
    }
}
