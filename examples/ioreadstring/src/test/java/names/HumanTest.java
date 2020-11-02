package names;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanTest {

    private Human h = new Human("John", "Doe");


    @Test
    public void createHumanTest() {
        assertEquals("John", h.getFirstName());
        assertEquals("Doe", h.getLastName());
    }

}
