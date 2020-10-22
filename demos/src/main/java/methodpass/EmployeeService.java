package methodpass;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public void tryChangeValues(int yearOfBirth, String name, List<String> courses) {
        yearOfBirth = 1970;
        name = "John";
        courses.add("Java");

//        courses = new ArrayList<>();
//        courses.add("C#");
    }

}
