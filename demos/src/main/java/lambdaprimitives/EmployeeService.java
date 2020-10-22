package lambdaprimitives;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeService {

    public List<Employee> generateEmployees(String prefix, int number) {
        return IntStream
                .range(0, number)
                .mapToObj(i -> new Employee(prefix + " " + i, 0, null)) // IntFunction
                .collect(Collectors.toList());
    }

    public long sumSalary(List<Employee> employees) {
        return employees.stream().mapToInt(Employee::getSalary).sum(); // ToIntFunction
    }

    public Boundaries salaryBoundaries(List<Employee> employees) {
        IntSummaryStatistics stat = employees.stream().mapToInt(Employee::getSalary).summaryStatistics();
        return new Boundaries(stat.getMin(), stat.getMax());
    }

    public static class Boundaries {
        private int min;

        private int max;

        public Boundaries(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }
    }
}
