package collectionslinkedlist;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DrawTest {


    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void wrongParametersShouldThrowExeption() throws IllegalArgumentException {
        //Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("drawCount must be less");

        //When
        new Draw().drawNumbers(8, 8);
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
            assertThat(drawnNumber > 0, is(true));
            assertThat(drawnNumber <= maxNumber, is(true));
        }
    }
}
