package recursion;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FactorialCalculatorTest {

    @Test
    public void simplestCase() {
        // Given
        int number = 1;

        // When
        long actual = new FactorialCalculator().getFactorial(number);

        // Then
        assertThat(actual, equalTo(1L));
    }

    @Test
    public void greaterNumber() {
        // Given
        int number = 5;

        // When
        long actual = new FactorialCalculator().getFactorial(number);

        // Then
        assertThat(actual, equalTo(120L));
    }
}
