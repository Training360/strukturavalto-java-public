package interfaces.animal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuckTest {
    @Test
    public void getNumberofLegs() throws Exception {
        Duck duck = new Duck();

        assertEquals(2, duck.getNumberOfLegs());
    }

    @Test
    public void getName() throws Exception {
        Duck duck = new Duck();

        assertEquals("Duck", duck.getName());
    }

}