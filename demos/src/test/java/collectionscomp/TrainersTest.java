package collectionscomp;

import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainersTest {

    @Test
    public void testSort() {
        List<String> names = Arrays.asList("Joe", "Jack", "Jane");

        Collections.sort(names);

        assertEquals(Arrays.asList("Jack", "Jane", "Joe"), names);


    }

    @Test
    public void testTrainersSort() {
        List<Trainer> trainers = Arrays.asList(
                new Trainer("Joe", 3),
                new Trainer("Jack", 2),
                new Trainer("Jane", 1)
        );
        Collections.sort(trainers);
        assertEquals("Jack", trainers.get(0).getName());

        Collections.sort(trainers, new Comparator<Trainer>() {
            @Override
            public int compare(Trainer o1, Trainer o2) {
                return o1.getSalary() - o2.getSalary();
            }
        });
        assertEquals("Jane", trainers.get(0).getName());

        Collections.sort(trainers, new Comparator<Trainer>() {
            @Override
            public int compare(Trainer o1, Trainer o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        assertEquals("Joe", trainers.get(0).getName());
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

        assertEquals(Arrays.asList("Ábel", "éva", "jack", "Jack", "Jane", "Joe"), names);


    }
}
