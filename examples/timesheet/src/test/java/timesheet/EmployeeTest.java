package timesheet;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    Employee employee = new Employee("John", "Connor");

    @Test
    public void createEmployee() {
        assertEquals("John Connor", employee.getName());
    }
}