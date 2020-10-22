package collectionscomp;

import org.junit.Test;

import java.text.Collator;
import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrainersTest {

    @Test
    public void testSort() {
        List<String> names = Arrays.asList("Joe", "Jack", "Jane");

        Collections.sort(names);

        assertThat(names, equalTo(Arrays.asList("Jack", "Jane", "Joe")));


    }

    @Test
    public void testTrainersSort() {
        List<Trainer> trainers = Arrays.asList(
                new Trainer("Joe", 3),
                new Trainer("Jack", 2),
                new Trainer("Jane", 1)
        );
        Collections.sort(trainers);
        assertThat(trainers.get(0).getName(), equalTo("Jack"));

        Collections.sort(trainers, new Comparator<Trainer>() {
            @Override
            public int compare(Trainer o1, Trainer o2) {
                return o1.getSalary() - o2.getSalary();
            }
        });
        assertThat(trainers.get(0).getName(), equalTo("Jane"));

        Collections.sort(trainers, new Comparator<Trainer>() {
            @Override
            public int compare(Trainer o1, Trainer o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        assertThat(trainers.get(0).getName(), equalTo("Joe"));
    }

    public class SalaryComparator implements Comparator<Trainer> {
        @Override
        public int compare(Trainer o1, Trainer o2) {
            return o1.getSalary() - o2.getSalary();
        }
    }

    @Test
    public void testSortWithAcutes() {
        List<String> names = Arrays.asList("Joe", "Jack", "Jane", "Ábel", "éva", "jack");

        Collections.sort(names, Collator.getInstance(new Locale("hu", "HU")));

        assertThat(names, equalTo(Arrays.asList("Ábel", "éva", "jack", "Jack", "Jane", "Joe")));


    }
}
