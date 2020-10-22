package lambdastreams.baseoperations;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumbersTest {

    @Test
    public void min() {
        Numbers numbers = new Numbers(Arrays.asList(1, 4, 7, 2, -3, 9, -4));

        assertThat(numbers.min(), equalTo(Optional.of(-4)));
    }

    @Test
    public void minForEmptyList() {
        Numbers numbers = new Numbers(Collections.emptyList());

        assertThat(numbers.min(), equalTo(Optional.empty()));
    }

    @Test
    public void sum() {
        Numbers numbers = new Numbers(Arrays.asList(1, 4, 7, 2, -3, 9, -4));

        assertThat(numbers.sum(), equalTo(16));
    }

    @Test
    public void sumForEmptyList() {
        Numbers numbers = new Numbers(Collections.emptyList());

        assertThat(numbers.sum(), equalTo(0));
    }

    @Test
    public void getDistinctElements() {
        Numbers numbers = new Numbers(Arrays.asList(1, 2, 1, 2, 1, 2, 4, 4, 4, 6));

        assertThat(numbers.getDistinctElements().size(), equalTo(4));
    }

    @Test
    public void isAllPositive() {
        Numbers numbers = new Numbers(Arrays.asList(1, 2, 1, 2, 1, 2, 4, 4, 4, 6));

        assertThat(numbers.isAllPositive(), is(true));
    }

    @Test
    public void isNotAllPositive() {
        Numbers numbers = new Numbers(Arrays.asList(1, 4, 7, 2, -3, 9, -4));

        assertThat(numbers.isAllPositive(), is(false));
    }
}
