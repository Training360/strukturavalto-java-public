package lambdastreams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReduceTest {

    List<Employee> employees = Arrays.asList(
            new Employee("John Doe"),
            new Employee("Jane Doe"),
            new Employee("Joe Doe"),
            new Employee("John John Smith")
    );

    @Test
    public void testReduce() {
        int length = employees.stream().reduce(
                0,
                (i, e) -> i + e.getName().length(),
                (i1, i2) -> i1 + i2
        );
        assertEquals(38, length);
    }

    @Test
    public void testNameCounter() {
        NameCounter nameCounter = employees.stream().reduce(
                new NameCounter(),
                (nc, e) -> nc.add(e),
                (nc1, nc2) -> nc1.add(nc2)
        );
        assertEquals(1, nameCounter.getThreePartName());
        assertEquals(3, nameCounter.getTwoPartName());
    }

    @Test
    public void testNameCounterCollect() {
        NameCounterMod nameCounterMod =
                employees.stream().collect(
                        NameCounterMod::new,
                        (counter, employee) -> counter.add(employee),
                        (c1, c2) -> c1.add(c2)
                );
        assertEquals(3, nameCounterMod.getTwoPartName());
        assertEquals(1, nameCounterMod.getThreePartName());
    }
}
