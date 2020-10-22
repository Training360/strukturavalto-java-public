package lambdastreams;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class StreamTest {

    List<Employee> employees = Arrays.asList(
            new Employee("John Doe"),
            new Employee("Jane Doe"),
            new Employee("Joe Doe"),
            new Employee("John Smith")
    );

    @Test
    public void testCount() {
        assertThat(Stream.empty().count(), equalTo(0L));

        assertThat(Stream.of(new Employee("John Doe"),
                new Employee("Jack Doe")).count(), equalTo(2L));

        Stream<Employee> s = Stream.of(new Employee("John Doe"),
                new Employee("Jack Doe"));
        assertThat(s.count(), equalTo(2L));


        assertThat(employees.stream().count(), equalTo(4L));
    }

    @Test
    public void testMin() {
        Employee employee =
                employees.stream().min(Comparator.comparing(Employee::getName))
                        .get();
        assertThat(employee.getName(), equalTo("Jane Doe"));
    }

    @Test
    public void testFindFirst()
    {
        Employee employee =
                employees.stream().findFirst().get();
        assertThat(employee.getName(), equalTo("John Doe"));
    }

    @Test
    public void testAllMatch() {
        boolean result = employees.stream().allMatch(e -> e.getName().length() > 5);
        assertThat(result, equalTo(true));

        assertThat(employees.stream().allMatch(e -> e.getName().startsWith("a")),
                equalTo(false));
    }

    @Test
    public void testForEach() {
        employees.stream().forEach(e -> e.setName(e.getName().toUpperCase()));
        assertThat(employees.get(0).getName(), equalTo("JOHN DOE"));
    }


}
