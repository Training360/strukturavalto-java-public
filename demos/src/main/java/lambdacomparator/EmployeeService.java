package lambdacomparator;

import java.util.Comparator;
import java.util.List;

public class EmployeeService {

    public List<Employee> sortByName(List<Employee> employees) {
//        employees.sort(new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

//        employees.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        employees.sort(Comparator.comparing(Employee::getName));
        return employees;
    }

    public List<Employee> sortBySalaryThanName(List<Employee> employees) {
        employees.sort(Comparator.comparingInt(Employee::getSalary).thenComparing(Employee::getName));
        return employees;
    }

    public List<Employee> sortByCardNumberNullsFirst(List<Employee> employees) {
        employees.sort(Comparator.comparing(Employee::getCardNumber, Comparator.nullsFirst(Comparator.naturalOrder()))
                .thenComparing(Employee::getName));
        return employees;
    }


    public List<Employee> sortByNameReversed(List<Employee> employees) {
        employees.sort(Comparator.comparing(Employee::getName).reversed());

//        employees.sort(Comparator.comparing(Employee::getName, Comparator.reverseOrder()));
        return employees;
    }

}
