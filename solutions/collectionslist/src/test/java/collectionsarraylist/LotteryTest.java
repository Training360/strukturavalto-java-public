package collectionsarraylist;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashSet;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LotteryTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void wrongParametersShouldThrowExeption() throws IllegalArgumentException {
        //Given
        int lotteryType = 6;
        int ballCount = 6;

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Balls must be more then the winning numbers!");

        //When
        new Lottery().selectWinningNumbers(lotteryType, ballCount);
    }

    @Test
    public void winningNumbersCountShouldBeEqualToLotteryType() throws IllegalArgumentException {

        //Given
        int lotteryType = 5;
        int ballCount = 90;

        //When
        List<Integer> winningNumbers = new Lottery().selectWinningNumbers(lotteryType, ballCount);

        //Then
        assertThat(new HashSet<>(winningNumbers).size(), equalTo(lotteryType));
        for (int winningNumber : winningNumbers) {
            assertThat(winningNumber > 0, is(true));
            assertThat(winningNumber <= ballCount, is(true));
        }
    }

}


