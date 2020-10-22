package datenewtypes;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RendezvousTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void emptyPatternShouldThrowException() {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Empty pattern string");
        // When
        new Rendezvous("10:20", "");
    }

    @Test
    public void emptyTimeStringShouldThrowException() {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal time string");
        // When
        new Rendezvous("", "hh:mm");
    }

    @Test
    public void illegalTimeStringShouldThrowException() {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal time string");
        // When
        new Rendezvous("10:20:20", "hh:mm");
    }

    @Test
    public void testToString() {
        // Given
        Rendezvous rendezvous = new Rendezvous(21, 30);
        //Then
        assertThat(rendezvous.toString("HH-mm"), equalTo("21-30"));
    }

    @Test
    public void emptyPatternInToStringMethodShouldThrowException() {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Empty pattern string");
        // When
        new Rendezvous("10:20", "HH:mm").toString("\t");
    }

    @Test
    public void testCountMinutesLeft() {
        // Given
        LocalTime base = LocalTime.of(20, 30);
        Rendezvous rendezvous = new Rendezvous(22, 0);
        //Then
        assertThat(rendezvous.countMinutesLeft(base), equalTo(90));
    }

    @Test
    public void tooLateToGoShouldThrowException() {
        // Given
        LocalTime now = LocalTime.of(15, 0);
        exception.expect(MissedOpportunityException.class);
        exception.expectMessage("Too late!");
        // When
        new Rendezvous(10, 30).countMinutesLeft(now);
    }

    @Test
    public void testPushLater() {
        // Given
        Rendezvous rendezvous = new Rendezvous(22, 0);
        //When
        rendezvous.pushLater(0, 90);
        //Then
        assertThat(rendezvous.toString("HH:mm"), equalTo("23:30"));
    }

    @Test
    public void testPullEarlier() {
        // Given
        Rendezvous rendezvous = new Rendezvous(22, 0);
        //When
        rendezvous.pullEarlier(1, 15);
        //Then
        assertThat(rendezvous.toString("HH:mm"), equalTo("20:45"));
    }
}
