package statemachine.elevator;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElevatorTest {

    @Test
    public void goUp() throws InterruptedException {
        Elevator elevator = new Elevator();
        elevator.pushButtonToGoToFirstFloor();
        elevator.work();

        String actualStateInfo = elevator.getHistory();
        assertEquals("[Ground Floor Open, Ground Floor Closed, First Floor Closed, First Floor Open]", actualStateInfo);
    }

    @Test
    public void goUpAndDown() throws InterruptedException {
        Elevator elevator = new Elevator();
        elevator.pushButtonToGoToFirstFloor();
        elevator.work();
        elevator.pushButtonToGoToGroundFloor();
        elevator.work();

        String actualStateInfo = elevator.getHistory();
        assertEquals("[Ground Floor Open, Ground Floor Closed, First Floor Closed, First Floor Open, First Floor Closed, Ground Floor Closed, Ground Floor Open]", actualStateInfo);
    }

    @Test
    public void goUpAndCallDown() throws InterruptedException {
        Elevator elevator = new Elevator();
        elevator.pushButtonToGoToFirstFloor();
        elevator.work();
        elevator.pushCallButtonOnGroundFloor();
        elevator.work();

        String actualStateInfo = elevator.getHistory();
        assertEquals("[Ground Floor Open, Ground Floor Closed, First Floor Closed, First Floor Open, First Floor Closed, Ground Floor Closed, Ground Floor Open]", actualStateInfo);
    }

    @Test
    public void goDown() throws InterruptedException {
        Elevator elevator = new Elevator(new FirstFloorClosed());
        elevator.pushCallButtonOnFirstFloor();
        elevator.pushCallButtonOnGroundFloor();
        elevator.pushButtonToGoToGroundFloor();
        elevator.work();

        String actualStateInfo = elevator.getHistory();
        assertEquals("[First Floor Closed, First Floor Open, First Floor Closed, Ground Floor Closed, Ground Floor Open]", actualStateInfo);
    }
}