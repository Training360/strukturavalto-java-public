package statemachine.seatheater;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class SeatHeaterStateTest {

    @Test
    public void testNext() {

        assertThat(SeatHeaterState.OFF.next(), is(SeatHeaterState.THREE));
        assertThat(SeatHeaterState.THREE.next(), is(SeatHeaterState.TWO));
        assertThat(SeatHeaterState.TWO.next(), is(SeatHeaterState.ONE));
        assertThat(SeatHeaterState.ONE.next(), is(SeatHeaterState.OFF));
    }

}
