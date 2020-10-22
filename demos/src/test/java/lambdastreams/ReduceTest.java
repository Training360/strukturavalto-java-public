package lambdastreams;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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
        assertThat(length, equalTo(38));
    }

    @Test
    public void testNameCounter() {
        NameCounter nameCounter = employees.stream().reduce(
                new NameCounter(),
                (nc, e) -> nc.add(e),
                (nc1, nc2) -> nc1.add(nc2)
        );
        assertThat(nameCounter.getThreePartName(), equalTo(1));
        assertThat(nameCounter.getTwoPartName(), equalTo(3));
    }

    @Test
    public void testNameCounterCollect() {
        NameCounterMod nameCounterMod =
                employees.stream().collect(
                        NameCounterMod::new,
                        (counter, employee) -> counter.add(employee),
                        (c1, c2) -> c1.add(c2)
                );
        assertThat(nameCounterMod.getTwoPartName(), equalTo(3));
        assertThat(nameCounterMod.getThreePartName(), equalTo(1));
    }
}
