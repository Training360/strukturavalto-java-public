package employee;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testCreate() {
        Employee employee = new Employee("Kis Géza", "minőségellenőr", 520000);

        assertEquals("Kis Géza", employee.getName());
        assertEquals("minőségellenőr", employee.getJob());
        assertEquals(520000, employee.getSalary());
    }

    @Test
    public void testCreateWithEmptyName() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Name must not be empty.");
        new Employee("", "minőségellenőr", 520000);
    }

    @Test
    public void testCreateWithNullJob() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Job must not be empty.");
        new Employee("Kis Géza", null, 520000);
    }

    @Test
    public void testCreateWithNegativeSalary() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Salary must be positive.");
        new Employee("Kis Géza", "minőségellenőr", -520000);
    }

    @Test
    public void testToString() {
        Employee employee = new Employee("Kis Géza", "minőségellenőr", 520000);

        assertEquals("Kis Géza - minőségellenőr - 520000 Ft", employee.toString());
    }
}
