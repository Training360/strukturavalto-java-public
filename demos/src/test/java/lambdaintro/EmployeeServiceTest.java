package lambdaintro;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

        Employee result = new EmployeeService().findFirst(employees,
                employee -> employee.getName().startsWith("Jane"));

        assertThat(result.getName(), equalTo("Jane Doe"));
    }
}
