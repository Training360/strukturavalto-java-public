package methodchain.robot;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {

    private Robot robot;

    @BeforeEach
    public void setUp() {
        this.robot = new Robot();
    }

    @AfterEach
    public void tearDown() {
        this.robot = null;
    }

    @Test
    public void testGoAndRotate() {
        //When
        robot.go(5).go(10).rotate(30);
        //Then
        assertEquals(15, robot.getDistance());
        assertEquals(30, robot.getAzimut());
    }

    @Test
    public void testRotate() {
        //When
        robot.rotate(45).rotate(45).rotate(-90);
        //Then
        assertEquals(0, robot.getAzimut());
    }

    //Bónusz feladat tesztje, kommentezd ki az alapfeladathoz
    @Test
    public void testNavigationChain() {
        //When
        robot.go(5).rotate(45).registerNavigationPoint().go(10).rotate(-15).registerNavigationPoint();
        //Then
        assertEquals("[distance: 5 azimut: 45, distance: 15 azimut: 30]", robot.getNavigationList().toString());
    }
}