package sorting;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SortingTest {

    @Test
    public void testSortArray() {
        int[] i = {3, 1, 6, 9, 5, 3};
        Arrays.sort(i);
        assertArrayEquals(new int[]{1, 3, 3, 5, 6, 9}, i);
    }

    @Test
    public void testSortList() {
        List<Integer> i = Arrays.asList(3, 1, 6, 9, 5, 3);
        Collections.sort(i);

        assertEquals(Arrays.asList(1, 3, 3, 5, 6, 9), i);

        i = Arrays.asList(3, 1, 6, 9, 5, 3);
        //noinspection Convert2Lambda,Convert2Diamond
        i.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        assertEquals(Arrays.asList(1, 3, 3, 5, 6, 9), i);
    }

    @Test
    public void testSet() {
        //noinspection Convert2Lambda,Convert2Diamond
        Set<Trainer> s = new TreeSet<>(new Comparator<Trainer>() {
            @Override
            public int compare(Trainer o1, Trainer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        s.add(new Trainer("Jack", 3));
        s.add(new Trainer("Joe", 2));
        s.add(new Trainer("Jane", 1));
        System.out.println(s);

    }
}
