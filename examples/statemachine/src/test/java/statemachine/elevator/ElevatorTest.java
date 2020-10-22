package statemachine.elevator;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ElevatorTest {

    @Test
    public void goUp() throws InterruptedException {
        Elevator elevator = new Elevator();
        elevator.pushButtonToGoToFirstFloor();
        elevator.work();

        String actualStateInfo = elevator.getHistory();
        assertThat(actualStateInfo, equalTo("[Ground Floor Open, Ground Floor Closed, First Floor Closed, First Floor Open]"));
    }

    @Test
    public void goUpAndDown() throws InterruptedException {
        Elevator elevator = new Elevator();
        elevator.pushButtonToGoToFirstFloor();
        elevator.work();
        elevator.pushButtonToGoToGroundFloor();
        elevator.work();

        String actualStateInfo = elevator.getHistory();
        assertThat(actualStateInfo, equalTo("[Ground Floor Open, Ground Floor Closed, First Floor Closed, First Floor Open, First Floor Closed, Ground Floor Closed, Ground Floor Open]"));
    }

    @Test
    public void goUpAndCallDown() throws InterruptedException {
        Elevator elevator = new Elevator();
        elevator.pushButtonToGoToFirstFloor();
        elevator.work();
        elevator.pushCallButtonOnGroundFloor();
        elevator.work();

        String actualStateInfo = elevator.getHistory();
        assertThat(actualStateInfo, equalTo("[Ground Floor Open, Ground Floor Closed, First Floor Closed, First Floor Open, First Floor Closed, Ground Floor Closed, Ground Floor Open]"));
    }

    @Test
    public void goDown() throws InterruptedException {
        Elevator elevator = new Elevator(new FirstFloorClosed());
        elevator.pushCallButtonOnFirstFloor();
        elevator.pushCallButtonOnGroundFloor();
        elevator.pushButtonToGoToGroundFloor();
        elevator.work();

        String actualStateInfo = elevator.getHistory();
        assertThat(actualStateInfo, equalTo("[First Floor Closed, First Floor Open, First Floor Closed, Ground Floor Closed, Ground Floor Open]"));
    }
}