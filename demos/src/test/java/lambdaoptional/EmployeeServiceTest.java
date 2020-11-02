package lambdaoptional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    @Test
    public void testFindFirst() {
        List<Employee> employees =
                Arrays.asList(
                        new Employee("John Doe"),
                        new Employee("Jane Doe"),
                        new Employee("Jack Doe")
                );

        Optional<Employee> result = new EmployeeService().findFirst(employees,
                employee -> employee.getName().startsWith("Jane"));

        assertTrue(result.isPresent());
        assertEquals("Jane Doe", result.get().getName());
    }

    public void testNotFound() {
        List<Employee> employees =
                Arrays.asList(
                        new Employee("John Doe"),
                        new Employee("Jane Doe"),
                        new Employee("Jack Doe")
                );

        assertThrows(IllegalArgumentException.class, () -> {
            new EmployeeService().findFirst(employees,
                    employee -> employee.getName().startsWith("Joe")).orElseThrow(() -> new IllegalArgumentException("Not found"));

        });
    }

    @Test
    public void testDefault() {
        List<Employee> employees =
                Arrays.asList(
                        new Employee("John Doe"),
                        new Employee("Jane Doe"),
                        new Employee("Jack Doe")
                );

        Employee result = new EmployeeService().findFirst(employees,
                employee -> employee.getName().startsWith("Joe"))
        .orElseGet(() -> new Employee("Anonymous"));

        assertEquals("Anonymous", result.getName());
    }
}
