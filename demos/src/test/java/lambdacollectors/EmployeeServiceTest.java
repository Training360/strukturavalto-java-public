package lambdacollectors;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class EmployeeServiceTest {

    private List<Employee> employees = Arrays.asList(
            new Employee(1L, "John Doe", 100_000, "AAA"),
            new Employee(2L, "Jane Doe", 200_000, "BBB"),
            new Employee(3L, "Joe Doe", 150_000, "AAA"),
            new Employee(4L, "John Smith", 180_000, "BBB"));

    private EmployeeService employeeService = new EmployeeService();

    @Test
    public void testConcatenateNames() {
        String names = employeeService.concatenateNames(employees);

        assertEquals("John Doe, Jane Doe, Joe Doe, John Smith", names);
    }

    @Test
    public void testSumSalaries() {
        long sum = employeeService.sumSalaries(employees);

        assertEquals(630_000, sum);
    }

    @Test
    public void testFilterSalaryGreaterThan() {
        List<Employee> filtered = employeeService.filterSalaryGreaterThan(employees, 180_000);

        assertEquals(Arrays.asList("Jane Doe", "John Smith"),
                filtered.stream().map(Employee::getName).collect(Collectors.toList()));
    }

    @Test
    public void testGroupById() {
        Map<Long, Employee> grouped = employeeService.groupById(employees);
        assertEquals("Jane Doe", grouped.get(2L).getName());
    }

    @Test
    public void testGroupByDivision() {
        Map<String, List<Employee>> grouped = employeeService.groupByDivision(employees);
        assertEquals(Arrays.asList("Jane Doe", "John Smith"),
                grouped.get("BBB").stream().map(Employee::getName).collect(Collectors.toList()));
    }

    @Test
    public void testNoEmployeesPerDivision() {
        Map<String, Long> numbers = employeeService.noEmployeesPerDivision(employees);
        assertEquals(Long.valueOf(2), numbers.get("BBB"));
    }

    @Test
    public void testPartitionBySalary() {
        Map<Boolean, List<Employee>> partitions = employeeService.partitionBySalary(employees, 190_000);
        assertEquals("Jane Doe", partitions.get(true).stream().findAny().get().getName());
    }

    @Test
    public void testMinSalaryByDivision() {
        Map<String, Optional<Integer>> salaries = employeeService.minSalaryByDivision(employees);
        assertEquals(Integer.valueOf(100_000), salaries.get("AAA").get());
        assertEquals(Integer.valueOf(180_000), salaries.get("BBB").get());
    }
}
