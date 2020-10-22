package idread;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IdManagerTest {
    private IdManager idManager = new IdManager();


    @Test
    public void getIdsTest() {
        assertEquals(0, idManager.getIds().size());
        idManager.getIds().add("test");
        assertEquals(0, idManager.getIds().size());


    }


    @Test
    public void readIdFromFileTest() {

        assertEquals(0, idManager.getIds().size());

        idManager.readIdsFromFile("idnumbers.txt");

        assertEquals(6, idManager.getIds().size());

    }
}
