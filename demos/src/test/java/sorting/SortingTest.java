package sorting;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SortingTest {

    @Test
    public void testSortArray() {
        int[] i = {3, 1, 6, 9, 5, 3};
        Arrays.sort(i);
        assertThat(i, equalTo(new int[]{1, 3, 3, 5, 6, 9}));
    }

    @Test
    public void testSortList() {
        List<Integer> i = Arrays.asList(3, 1, 6, 9, 5, 3);
        Collections.sort(i);

        assertThat(i, equalTo(Arrays.asList(1, 3, 3, 5, 6, 9)));

        i = Arrays.asList(3, 1, 6, 9, 5, 3);
        i.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        assertThat(i, equalTo(Arrays.asList(1, 3, 3, 5, 6, 9)));
    }

    @Test
    public void testSet() {
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
