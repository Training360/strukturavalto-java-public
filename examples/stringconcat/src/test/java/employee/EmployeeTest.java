package employee;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {


    @Test
    public void testCreate() {
        Employee employee = new Employee("Kis Géza", "minőségellenőr", 520000);

        assertEquals("Kis Géza", employee.getName());
        assertEquals("minőségellenőr", employee.getJob());
        assertEquals(520000, employee.getSalary());
    }

    @Test
    public void testCreateWithEmptyName() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Employee("", "minőségellenőr", 520000));
        assertEquals("Name must not be empty.", ex.getMessage());
    }

    @Test
    public void testCreateWithNullJob() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Employee("Kis Géza", null, 520000));
        assertEquals("Job must not be empty.", ex.getMessage());
    }

    @Test
    public void testCreateWithNegativeSalary() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Employee("Kis Géza", "minőségellenőr", -520000));
        assertEquals("Salary must be positive.", ex.getMessage());
    }

    @Test
    public void testToString() {
        Employee employee = new Employee("Kis Géza", "minőségellenőr", 520000);

        assertEquals("Kis Géza - minőségellenőr - 520000 Ft", employee.toString());
    }
}
