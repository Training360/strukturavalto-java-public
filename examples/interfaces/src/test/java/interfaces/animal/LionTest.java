package interfaces.animal;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LionTest {
    @Test
    public void getNumberofLegs() {
        Lion lion = new Lion();
        assertEquals(4, lion.getNumberOfLegs());
    }

    @Test
    public void getName() {
        Lion lion = new Lion();
        assertEquals("Lion", lion.getName());
    }

}