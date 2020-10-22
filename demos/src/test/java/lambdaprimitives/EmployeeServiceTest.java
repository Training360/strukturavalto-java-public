package lambdaprimitives;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class EmployeeServiceTest {

    private List<Employee> employees = Collections.unmodifiableList(Arrays.asList(
            new Employee("John Doe", 180_000, null),
            new Employee("Jane Doe", 200_000, "bbb-123"),
            new Employee("Joe Doe", 100_000, null),
            new Employee("John Smith", 100_000, "aaa-123")));

    private EmployeeService employeeService = new EmployeeService();

    @Test
    public void testGenerateEmployees() {
        List<Employee> generated = employeeService.generateEmployees("John Doe", 3);

        assertEquals(Arrays.asList("John Doe 0", "John Doe 1", "John Doe 2"),
                generated.stream().map(Employee::getName).collect(Collectors.toList()));
    }

    @Test
    public void testSumSalary() {
        long sum = employeeService.sumSalary(employees);

        assertEquals(580_000, sum);
    }

    @Test
    public void testSalaryBoundaries() {
        EmployeeService.Boundaries boundaries = employeeService.salaryBoundaries(employees);

        assertEquals(100_000, boundaries.getMin());
        assertEquals(200_000, boundaries.getMax());
    }


}
