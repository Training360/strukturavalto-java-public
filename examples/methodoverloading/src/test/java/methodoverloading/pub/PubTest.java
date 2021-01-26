package methodoverloading.pub;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PubTest {

    @Test
    public void constructorTest() {
        //Given
        Pub pub = new Pub("Kurta kocsma", 10, 30);
        //Then
        assertEquals("Kurta kocsma", pub.getName());
        assertEquals(10, pub.getOpenFrom().getHours());
        assertEquals(30, pub.getOpenFrom().getMinutes());
    }

    @Test
    public void toStringTest() {
        //Given
        Pub pub = new Pub("Kurta kocsma", 10, 30);
        //Then
        assertEquals("Kurta kocsma;10:30", pub.toString());
    }
}