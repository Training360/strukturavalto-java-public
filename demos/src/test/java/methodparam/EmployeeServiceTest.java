package methodparam;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmployeeServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCreateEmployee() {
        new EmployeeService().createEmployee("John Doe", 1970, EmployeeType.FULL_TIME);
    }

    @Test
    public void testInvalid() {
        expectedException.expect(IllegalArgumentException.class);
        new EmployeeService().createEmployee("   ", 1970, EmployeeType.FULL_TIME);
    }

    @Test
    public void testFind() {
        List<String> names = Arrays.asList("John Doe", "Jane Doe", "Jack Doe");
        Result result = new EmployeeService().findEmployee("Jane", names);

        assertEquals("Jane Doe", result.getName());
        assertEquals(1, result.getIndex());
    }

    @Test
    public void testList() {
        List<String> names = new EmployeeService().listNames();
//        for (String name: names) {
//            System.out.println(name);
//        }

        assertEquals(0, names.size());
    }
}
