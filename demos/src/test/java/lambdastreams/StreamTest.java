package lambdastreams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StreamTest {

    List<Employee> employees = Arrays.asList(
            new Employee("John Doe"),
            new Employee("Jane Doe"),
            new Employee("Joe Doe"),
            new Employee("John Smith")
    );

    @Test
    public void testCount() {
        assertEquals(0L, Stream.empty().count());

        assertEquals(2L, Stream.of(new Employee("John Doe"),
                new Employee("Jack Doe")).count());

        Stream<Employee> s = Stream.of(new Employee("John Doe"),
                new Employee("Jack Doe"));
        assertEquals(2L, s.count());


        assertEquals(4L, employees.stream().count());
    }

    @Test
    public void testMin() {
        Employee employee =
                employees.stream().min(Comparator.comparing(Employee::getName))
                        .get();
        assertEquals("Jane Doe", employee.getName());
    }

    @Test
    public void testFindFirst()
    {
        Employee employee =
                employees.stream().findFirst().get();
        assertEquals("John Doe", employee.getName());
    }

    @Test
    public void testAllMatch() {
        boolean result = employees.stream().allMatch(e -> e.getName().length() > 5);
        assertTrue(result);

        assertFalse(employees.stream().allMatch(e -> e.getName().startsWith("a")));
    }

    @Test
    public void testForEach() {
        employees.stream().forEach(e -> e.setName(e.getName().toUpperCase()));
        assertEquals("JOHN DOE", employees.get(0).getName());
    }


}
