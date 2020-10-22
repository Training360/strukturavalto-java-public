package methodparam;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public void createEmployee(String name, int yearOfBirth, EmployeeType employeeType) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name");
        }
        if (yearOfBirth < 1900 || yearOfBirth > 2019) {
            throw new IllegalArgumentException("Invalid year");
        }
    }

    public Result findEmployee(String prefix, List<String> names) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).startsWith(prefix)) {
                return new Result(names.get(i), i);
            }
        }
        throw new IllegalArgumentException("Can not find employee");
    }

    public List<String> listNames() {
        //return Arrays.asList("John Doe", "Jane Doe", "Jack Doe");
        return new ArrayList<>();
    }
}
