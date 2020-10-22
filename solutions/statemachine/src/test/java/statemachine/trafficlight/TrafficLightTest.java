package statemachine.trafficlight;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrafficLightTest {

    @Test
    public void testNext() {
        assertThat(TrafficLight.RED.next(), is(TrafficLight.RED_YELLOW));
        assertThat(TrafficLight.RED_YELLOW.next(), is(TrafficLight.GREEN));
        assertThat(TrafficLight.GREEN.next(), is(TrafficLight.YELLOW));
        assertThat(TrafficLight.YELLOW.next(), is(TrafficLight.RED));
    }

}
