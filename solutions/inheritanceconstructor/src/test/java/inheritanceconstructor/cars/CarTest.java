package inheritanceconstructor.cars;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CarTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void incorrectParameterShouldThrowException() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Tank capacity is less than fuel!");
        // When
        new Car(5.0, 50.0, 40.0);

    }

    @Test
    public void testModifyFuelAmount() {
        //Given
        Car car = new Car(5.0, 25.0, 40.0);
        //When
        car.modifyFuelAmount(-10.0);
        //Then
        assertThat(car.getFuel(), equalTo(15.0));
    }

    @Test
    public void testDrive() {
        //Given
        Car car = new Car(5.0, 25.0, 40.0);
        //When
        car.drive(100);
        //Then
        assertThat(car.getFuel(), equalTo(20.0));
    }

    @Test
    public void notEnoughFuelShouldThrowException() throws RuntimeException {
        // Given
        Car car = new Car(5.0, 25.0, 40.0);
        exception.expect(RuntimeException.class);
        exception.expectMessage("Not enough fuel available!");
        // When
        car.drive(600);
    }

    @Test
    public void testCalculateRefillAmount() {
        //Given
        Car car = new Car(5.0, 25.0, 40.0);
        //Then
        assertThat(car.calculateRefillAmount(), equalTo(15.0));
    }
}