package collectionslinkedlist;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class DrawTest {


    @Test
    public void wrongParametersShouldThrowExeption() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Draw().drawNumbers(8, 8);
        });
        assertEquals("drawCount must be less then 8!", ex.getMessage());
    }

    @Test
    public void drawnNumbersCountShouldBeEqualToDrawCount() throws IllegalArgumentException {
        //Given
        int drawCount = 5;
        int maxNumber = 90;

        //When
        Set<Integer> drawnNumbers = new Draw().drawNumbers(drawCount, maxNumber);

        //Then
        // assertThat(drawnNumbers.size(), equalTo(drawCount));
        for (int drawnNumber : drawnNumbers) {
            assertTrue(drawnNumber > 0);
            assertTrue(drawnNumber <= maxNumber);
        }
    }
}
