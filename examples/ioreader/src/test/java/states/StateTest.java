package states;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateTest {


    private State state = new State("Wyoming", "Cheyenne");


    @Test
    public void createState() {
        assertEquals("Wyoming", state.getStateName());
        assertEquals("Cheyenne", state.getCapital());
    }

}
