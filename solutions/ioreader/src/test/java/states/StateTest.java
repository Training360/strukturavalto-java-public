package states;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateTest {


    private State state = new State("Wyoming","Cheyenne");


    @Test
    public void createState(){
        assertEquals("Wyoming",state.getStateName());
        assertEquals("Cheyenne",state.getCapital());
    }

}
