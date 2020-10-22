package names;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanTest {

    private Human h = new Human("John","Doe");




    @Test
    public void createHumanTest(){
        assertEquals("John",h.getFirstName());
        assertEquals("Doe",h.getLastName());
    }

}
