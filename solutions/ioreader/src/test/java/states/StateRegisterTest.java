package states;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class StateRegisterTest {

    private StateRegister stateRegister = new StateRegister();



    @Rule
    public ExpectedException ee = ExpectedException.none();

    @Test
    public void testGetStates(){
        assertEquals(0,stateRegister.getStates().size());
        stateRegister.getStates().add(new State("New York","Albany"));
        assertEquals(0,stateRegister.getStates().size());
    }


    @Test
    public void testWithWrongFileName(){
        ee.expect(IllegalStateException.class);
        ee.expectMessage("Can't read file!");
        stateRegister.readStatesFromFile("myFile.txt");
    }

    @Test
    public void testReadFile(){
        assertEquals(0,stateRegister.getStates().size());

        stateRegister.readStatesFromFile("stateregister.txt");

        assertEquals(50,stateRegister.getStates().size());
        assertEquals("Wyoming",stateRegister.getStates().get(49).getStateName());
    }


    @Test
    public void wrongStateNameTest(){
        ee.expect(IllegalArgumentException.class);
        ee.expectMessage("No state with this name!");
        stateRegister.readStatesFromFile("stateregister.txt");
        stateRegister.findCapitalByStateName("Canada");
    }

    @Test
    public void findCapitalByStateNameTest(){
        stateRegister.readStatesFromFile("stateregister.txt");

        assertEquals("Albany",stateRegister.findCapitalByStateName("New York"));
        assertEquals("Juneau",stateRegister.findCapitalByStateName("Alaska"));

    }


}
