package methodpass;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmployeeServiceTest {

    @Test
    public void testTryChangeValues() {
        int originalYearOfBirth = 1980;
        String originalName = "Jack";
        List<String> originalCourses = new ArrayList<>();
        new EmployeeService().tryChangeValues(originalYearOfBirth, originalName, originalCourses);

        assertEquals(1980, originalYearOfBirth);
        assertEquals("Jack", originalName);

        assertEquals(1, originalCourses.size());
    }
}
