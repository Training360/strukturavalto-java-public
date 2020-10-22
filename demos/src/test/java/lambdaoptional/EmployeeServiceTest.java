package lambdaoptional;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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

        assertThat(result.isPresent(), equalTo(true));
        assertThat(result.get().getName(), equalTo("Jane Doe"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotFound() {
        List<Employee> employees =
                Arrays.asList(
                        new Employee("John Doe"),
                        new Employee("Jane Doe"),
                        new Employee("Jack Doe")
                );

        new EmployeeService().findFirst(employees,
                employee -> employee.getName().startsWith("Joe")).orElseThrow(() -> new IllegalArgumentException("Not found"));
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

        assertThat(result.getName(), equalTo("Anonymous"));
    }
}
