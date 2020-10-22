package lambdaintermediate;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class IntermediateTest {

    List<Employee> employees = Arrays.asList(
            new Employee("John Doe"),
            new Employee("Jane Doe"),
            new Employee("Joe Doe"),
            new Employee("John Smith")
    );

    @Test
    public void testFilter() {
        List<Employee> filtered =
                employees.stream().filter(e -> e.getName().startsWith("John"))
                .collect(Collectors.toList());

        assertThat(filtered.size(), equalTo(2));
        assertThat(filtered.get(0).getName(), equalTo("John Doe"));
    }

    @Test
    public void testDistinct() {
        List<String> filtered = Stream.of("John", "John", "Jane", "John")
                .distinct().collect(Collectors.toList());
        assertThat(filtered, equalTo(Arrays.asList("John", "Jane")));
    }

    @Test
    public void testLimitSkip() {
        List<Employee> filtered = employees.stream()
                .skip(1).limit(2).collect(Collectors.toList());
        assertThat(filtered.size(), equalTo(2));
        assertThat(filtered.get(0).getName(), equalTo("Jane Doe"));
    }

    @Test
    public void testInfinite() {
        List<Integer> l = Stream.iterate(1, n -> n + 2).skip(2).limit(3).
                collect(Collectors.toList());
        assertThat(l, equalTo(Arrays.asList(5, 7, 9)));
    }

    @Test
    public void testMap() {
        List<String> names = employees.stream().limit(2)
                .map(e -> e.getName()).collect(Collectors.toList());
        assertThat(names, equalTo(Arrays.asList("John Doe", "Jane Doe")));
    }

    @Test
    public void testFlatMap() {
        List<String> s1 = Arrays.asList("John Doe", "Jane Doe");
        List<String> s2 = Arrays.asList("Jack Doe", "Joe Doe");

        List<String> names = Stream.of(s1, s2).flatMap(l -> l.stream()).collect(Collectors.toList());

        assertThat(names, equalTo(Arrays.asList("John Doe", "Jane Doe", "Jack Doe", "Joe Doe")));
    }

    @Test
    public void testSorted() {
        List<Employee> sorted = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
        assertThat(sorted.get(0).getName(), equalTo("Jane Doe"));
    }

    @Test
    public void testPeek() {
        List<String> names = employees.stream()
                .map(e -> e.getName())
                .sorted()
                .limit(2)
                .collect(Collectors.toList());

        assertThat(names, equalTo(Arrays.asList("Jane Doe", "Joe Doe")));
    }
}
