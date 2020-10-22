package lambdacollectors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeService {

    public String concatenateNames(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
    }

    public long sumSalaries(List<Employee> employees) {
//        return employees.stream()
//                .collect(Collectors.summingInt(Employee::getSalary)); // ToIntFunction
        return employees.stream()
                .collect(Collectors.summarizingInt(Employee::getSalary)).getSum();
    }

    public List<Employee> filterSalaryGreaterThan(List<Employee> employees, int min) {
        return employees.stream().filter(e -> e.getSalary() >= min).collect(Collectors.toList());
    }

    public Map<Long, Employee> groupById(List<Employee> employees) {
        return employees.stream().collect(Collectors.toMap(
                Employee::getId,
                e -> e
        ));
    }

    public Map<String, List<Employee>> groupByDivision(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDivision));
    }

    public Map<String, Long> noEmployeesPerDivision(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDivision,
                Collectors.counting()));
    }

    public Map<Boolean, List<Employee>> partitionBySalary(List<Employee> employees, int boundary) {
        return employees.stream().collect(
                Collectors.partitioningBy(e -> e.getSalary() >= boundary)
        );
    }

    public Map<String, Optional<Integer>> minSalaryByDivision(List<Employee> employees) {
        return employees.stream().collect(
                Collectors.groupingBy(Employee::getDivision,
                        Collectors.mapping(Employee::getSalary, Collectors.minBy(Comparator.naturalOrder())))
        );
    }
}
