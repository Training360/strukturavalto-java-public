package inheritanceconstructor.cars;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class JeepTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void incorrectParameterShouldThrowException() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Tank capacity is less than fuel!");
        // When
        new Jeep(10.0, 60.0, 50.0, 40.0, 20.0);
    }

    @Test
    public void testCalculateRefillAmount() {
        //Given
        Jeep jeep = new Jeep(10.0, 30.0, 50.0, 40.0, 20.0);
        //Then
        assertThat(jeep.calculateRefillAmount(), equalTo(40.0));
    }

    @Test
    public void testDrive() {
        //Given
        Jeep jeep = new Jeep(10.0, 30.0, 50.0, 40.0, 20.0);
        //When
        jeep.drive(300);
        //Then
        assertThat(jeep.getExtraFuel(), equalTo(0.0));
        assertThat(jeep.getFuel(), equalTo(20.0));
    }

    @Test
    public void notEnoughFuelShouldThrowException() throws RuntimeException {
        // Given
        Jeep jeep = new Jeep(10.0, 30.0, 50.0, 40.0, 20.0);
        exception.expect(RuntimeException.class);
        exception.expectMessage("Not enough fuel available!");
        // When
        jeep.drive(600);
    }
}