package controlselection.greetings;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GreetingsTest {

    @Test
    public void testGreet() {
        Greetings greetings = new Greetings();
        assertThat(greetings.greet(4, 30), equalTo("jó éjt"));
        assertThat(greetings.greet(5, 0), equalTo("jó éjt"));
        assertThat(greetings.greet(5, 1), equalTo("jó reggelt"));
        assertThat(greetings.greet(9, 0), equalTo("jó reggelt"));
        assertThat(greetings.greet(9, 1), equalTo("jó napot"));
        assertThat(greetings.greet(18, 30), equalTo("jó napot"));
        assertThat(greetings.greet(18, 31), equalTo("jó estét"));
        assertThat(greetings.greet(20, 00), equalTo("jó estét"));
        assertThat(greetings.greet(20, 01), equalTo("jó éjt"));
    }
}
