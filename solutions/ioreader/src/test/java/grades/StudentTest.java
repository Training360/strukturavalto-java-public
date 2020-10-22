package grades;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    private Student student = new Student("Jack_Doe", Arrays.asList(2,3,4,5));



    @Test
    public void getListTest(){
        assertEquals(4,student.getGradeList().size());
        student.getGradeList().add(3);
        assertEquals(4,student.getGradeList().size());
    }

    @Test
    public void createStudentTest(){

        assertEquals("Jack_Doe",student.getName());
        assertEquals(5 ,student.getGradeList().get(3).longValue());
    }

    @Test
    public void testAverage(){
        assertEquals(3.5,student.average(),0.000001);
    }

    @Test
    public void testIncreasing(){
        assertEquals(true,student.isIncreasing());

        Student notIncreasing= new Student("Bad_Student",Arrays.asList(2,3,2,5,4));

        assertEquals(false,notIncreasing.isIncreasing());
    }

}
