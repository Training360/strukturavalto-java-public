package methodoverloading.pub;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ListOfGoodPubsTest {


    @Test
    public void emptyPubListShouldThrowException() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new ListOfGoodPubs(new ArrayList<>()));
        assertEquals("Pub list is empty!", ex.getMessage());
    }

    @Test
    public void testFindTheBest() {

        ListOfGoodPubs goodPubs = new ListOfGoodPubs(Arrays.asList(
                new Pub("A két rablóhoz", 12, 20),
                new Pub("Kurta kocsma", 9, 0),
                new Pub("Kings", 23, 0),
                new Pub("Fehér ló", 22, 30),
                new Pub("Fekete macska", 23, 30)
        ));

        assertEquals("Kurta kocsma;9:0", goodPubs.findTheBest().toString());
    }
}