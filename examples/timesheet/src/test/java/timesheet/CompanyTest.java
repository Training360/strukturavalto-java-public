package timesheet;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CompanyTest {

    Company company = new Company(
            CompanyTest.class.getResourceAsStream("/employees.txt"),
            CompanyTest.class.getResourceAsStream("/projects.txt"));


    @TempDir
    public File temporaryFolder;


    @Test
    public void readEmployees() {
        assertEquals("John Connor", company.getEmployees().get(0).getName());
        assertEquals("Vincent Vega", company.getEmployees().get(3).getName());
    }

    @Test
    public void readProjects() {
        assertEquals("Java", company.getProjects().get(0).getName());
        assertEquals("C++", company.getProjects().get(3).getName());
    }

    @Test
    public void calculateProjectByNameYearMonthTest() {
        company.addTimeSheetItem(
                new Employee("John", "Connor"),
                new Project("Java"),
                LocalDateTime.of(2013, Month.JANUARY, 27, 8, 0, 0),
                LocalDateTime.of(2013, Month.JANUARY, 27, 16, 10, 0)
        );


        company.addTimeSheetItem(
                new Employee("John", "Connor"),
                new Project("Java"),
                LocalDateTime.of(2013, Month.JANUARY, 26, 8, 0, 0),
                LocalDateTime.of(2013, Month.JANUARY, 26, 10, 10, 0)
        );


        company.addTimeSheetItem(
                new Employee("John", "Connor"),
                new Project("C++"),
                LocalDateTime.of(2013, Month.JANUARY, 25, 8, 0, 0),
                LocalDateTime.of(2013, Month.JANUARY, 25, 12, 10, 0)
        );
        company.addTimeSheetItem(
                new Employee("John", "Connor"),
                new Project("C++"),
                LocalDateTime.of(2013, Month.FEBRUARY, 25, 8, 0, 0),
                LocalDateTime.of(2013, Month.FEBRUARY, 25, 12, 10, 0)
        );


        assertEquals(10L, company.calculateProjectByNameYearMonth("John Connor", 2013, 1).get(0).getTime());
        assertEquals(0L, company.calculateProjectByNameYearMonth("John Connor", 2013, 1).get(1).getTime());
        assertEquals(4L, company.calculateProjectByNameYearMonth("John Connor", 2013, 1).get(3).getTime());
    }

    @Test
    public void wrongNameTest() {
        assertThrows(IllegalArgumentException.class, () -> company.calculateProjectByNameYearMonth("James", 2013, 1));

    }

    @Test
    public void prepareAndPrintReportTest() throws IOException {
        //Given
        Path report = new File(temporaryFolder, "test.txt").toPath();
        String expected = "John Connor\t2013-01\t14\n" +
                "Java\t10\n" +
                "C++\t4\n";

        company.addTimeSheetItem(
                new Employee("John", "Connor"),
                new Project("Java"),
                LocalDateTime.of(2013, 1, 27, 8, 0, 0),
                LocalDateTime.of(2013, 1, 27, 16, 10, 0)
        );
        company.addTimeSheetItem(
                new Employee("John", "Connor"),
                new Project("Java"),
                LocalDateTime.of(2013, 1, 26, 8, 0, 0),
                LocalDateTime.of(2013, 1, 26, 10, 10, 0)
        );
        company.addTimeSheetItem(
                new Employee("John", "Connor"),
                new Project("C++"),
                LocalDateTime.of(2013, 1, 25, 8, 0, 0),
                LocalDateTime.of(2013, 1, 25, 12, 10, 0)
        );
        company.addTimeSheetItem(
                new Employee("John", "Connor"),
                new Project("C++"),
                LocalDateTime.of(2013, 2, 25, 8, 0, 0),
                LocalDateTime.of(2013, 2, 25, 12, 10, 0)
        );

        //When
        company.printToFile("John Connor", 2013, 1, report);

        //Then
        String content = Files.readString(report);
        assertEquals(expected, content);
    }
}