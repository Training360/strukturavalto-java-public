package collectionsautoboxing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IntegerOperationsTest {

    @Test
    public void checkElementTypeInList() {
        //Given
        List<Integer> numbers = new IntegerOperations().createList(2, 4, 6);
        //Then
        assertEquals(3, numbers.size());
        assertEquals(2, numbers.get(0));
        assertEquals(4, numbers.get(1));
    }

    @Test
    public void checkSumValueInList() {
        //Given
        IntegerOperations abox = new IntegerOperations();
        //Then
        assertEquals(12, abox.sumIntegerList(abox.createList(2, 4, 6)));
    }

    @Test
    public void sumIntegerObjects() {
        assertEquals(12, new IntegerOperations().sumIntegerObjects(2, 4, 6));
    }
}
