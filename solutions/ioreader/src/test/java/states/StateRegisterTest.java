package states;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StateRegisterTest {

    private StateRegister stateRegister = new StateRegister();


    @Test
    public void testGetStates() {
        assertEquals(0, stateRegister.getStates().size());
        stateRegister.getStates().add(new State("New York", "Albany"));
        assertEquals(0, stateRegister.getStates().size());
    }


    @Test
    public void testWithWrongFileName() {
        Exception ex = assertThrows(IllegalStateException.class, () -> stateRegister.readStatesFromFile("myFile.txt"));
        assertEquals("Can't read file!", ex.getMessage());
    }

    @Test
    public void testReadFile() {
        assertEquals(0, stateRegister.getStates().size());

        stateRegister.readStatesFromFile("stateregister.txt");

        assertEquals(50, stateRegister.getStates().size());
        assertEquals("Wyoming", stateRegister.getStates().get(49).getStateName());
    }


    @Test
    public void wrongStateNameTest() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            stateRegister.readStatesFromFile("stateregister.txt");
            stateRegister.findCapitalByStateName("Canada");
        });
        assertEquals("No state with this name!", ex.getMessage());
    }

    @Test
    public void findCapitalByStateNameTest() {
        stateRegister.readStatesFromFile("stateregister.txt");

        assertEquals("Albany", stateRegister.findCapitalByStateName("New York"));
        assertEquals("Juneau", stateRegister.findCapitalByStateName("Alaska"));

    }


}
