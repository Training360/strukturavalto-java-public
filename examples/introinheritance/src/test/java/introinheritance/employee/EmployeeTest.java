package introinheritance.employee;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class EmployeeTest {

    @Test
    public void testCreateEmployee() {
        //Given
        Employee employee = new Employee("John Doe", "1117 Budapest, Budafoki út 56.", 300_000);
        //Then
        assertThat(employee.getName(), equalTo("John Doe"));
        assertThat(employee.getAddress(), equalTo("1117 Budapest, Budafoki út 56."));
        assertThat(employee.getSalary(), equalTo(300_000.0));
    }

    @Test
    public void testMigrateEmployee() {
        //Given
        Employee employee = new Employee("John Doe", "1117 Budapest, Budafoki út 56.", 300_000);
        employee.migrate("1117 Budapest, Budafoki út 100.");
        //Then
        assertThat(employee.getAddress(), equalTo("1117 Budapest, Budafoki út 100."));
    }

    @Test
    public void testRaiseSalary() {
        //Given
        Employee employee = new Employee("John Doe", "1117 Budapest, Budafoki út 56.", 300_000);
        //When
        employee.raiseSalary(10);
        //Then
        assertThat(employee.getSalary(), equalTo(330_000.0));
    }
}
