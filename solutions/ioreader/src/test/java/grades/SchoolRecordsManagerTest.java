package grades;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SchoolRecordsManagerTest {

    private SchoolRecordsManager schoolRecordsManager = new SchoolRecordsManager();

    @Test
    public void readFromFiletest() {
        schoolRecordsManager.readGradesFromFile("grades.txt");

        assertEquals(4, schoolRecordsManager.getStudents().size());
        assertEquals(3, schoolRecordsManager.getStudents().get(2).getGradeList().get(1).longValue());
        assertEquals("Jason_Butler", schoolRecordsManager.getStudents().get(3).getName());
        assertEquals(4.0, schoolRecordsManager.getStudents().get(2).average(), 0.000001);

    }


    @Test
    public void classAverageTest() {
        schoolRecordsManager.readGradesFromFile("grades.txt");

        assertEquals(3.542, schoolRecordsManager.classAverage(), 0.001);
    }


}
