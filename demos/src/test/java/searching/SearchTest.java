package searching;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {

    @Test
    public void testArraySearch() {
       int[] i = {1, 3, 5, 6, 7, 9, 12, 4};
       Arrays.sort(i);

        assertThat(Arrays.binarySearch(i, 5), equalTo(3));
        assertThat(Arrays.binarySearch(i, 20) < 0, equalTo(true));
    }

    @Test
    public void testListSearch() {
        List<Integer> i = Arrays.asList(1, 3, 5, 6, 7, 9, 12);
        assertThat(Collections.binarySearch(i, 6), equalTo(3));

        assertThat(i.contains(6), equalTo(true));
        assertThat(i.contains(20), equalTo(false));

        assertThat(i.containsAll(Arrays.asList(1, 7)), equalTo(true));
        assertThat(i.containsAll(Arrays.asList(1, 20)), equalTo(false));

        assertThat(i.indexOf(6), equalTo(3));
        assertThat(i.indexOf(20) < 0, equalTo(true));

        assertThat(Collections.min(i), equalTo(1));
        assertThat(Collections.max(i), equalTo(12));

        List<Trainer> trainers = Arrays.asList(
                new Trainer("John", 3),
                new Trainer("Jack", 2),
                new Trainer("Jane", 1)
        );
        assertThat(Collections.min(trainers).getName(), equalTo("Jack"));

        assertThat(Collections.min(trainers,
                new Comparator<Trainer>() {
                    @Override
                    public int compare(Trainer o1, Trainer o2) {
                        return o1.getSalary() - o2.getSalary();
                    }
                }).getName(), equalTo("Jane"));
    }
}
