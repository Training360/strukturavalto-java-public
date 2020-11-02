package interfaces.animal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WormTest {
    @Test
    public void getNumberofLegs() {
        Worm worm = new Worm();

        assertEquals(0, worm.getNumberOfLegs());
    }

    @Test
    public void getName() {
        Worm worm = new Worm();

        assertEquals("Worm", worm.getName());
    }

}