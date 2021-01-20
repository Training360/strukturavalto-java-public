package timesheet;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectTest {

    Project project = new Project("Java");

    @Test
    public void createProjectTest() {
        assertEquals("Java", project.getName());
    }
}