package searching;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {

    @Test
    public void testArraySearch() {
       int[] i = {1, 3, 5, 6, 7, 9, 12, 4};
       Arrays.sort(i);

        assertEquals(3, Arrays.binarySearch(i, 5));
        assertTrue(Arrays.binarySearch(i, 20) < 0);
    }

    @Test
    public void testListSearch() {
        List<Integer> i = Arrays.asList(1, 3, 5, 6, 7, 9, 12);
        assertEquals(3, Collections.binarySearch(i, 6));

        assertTrue(i.contains(6));
        assertFalse(i.contains(20));

        assertTrue(i.containsAll(Arrays.asList(1, 7)));
        assertFalse(i.containsAll(Arrays.asList(1, 20)));

        assertEquals(3, i.indexOf(6));
        assertTrue(i.indexOf(20) < 0);

        assertEquals(1, Collections.min(i));
        assertEquals(12, Collections.max(i));

        List<Trainer> trainers = Arrays.asList(
                new Trainer("John", 3),
                new Trainer("Jack", 2),
                new Trainer("Jane", 1)
        );
        assertEquals("Jack", Collections.min(trainers).getName());

        assertEquals("Jane", Collections.min(trainers,
                new Comparator<Trainer>() {
                    @Override
                    public int compare(Trainer o1, Trainer o2) {
                        return o1.getSalary() - o2.getSalary();
                    }
                }).getName());
    }
}
