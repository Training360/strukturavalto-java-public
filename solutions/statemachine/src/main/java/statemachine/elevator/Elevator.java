package statemachine.elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private ElevatorState state;
    private boolean calledOnGroundFloor;
    private boolean calledOnFirstFloor;
    private DirectionType direction;
    private List<String> history = new ArrayList<>();

    public Elevator() {
        setState( new GroundFloorOpen(this));
        calledOnGroundFloor = false;
        calledOnFirstFloor = false;
        direction = DirectionType.NONE;
    }

    public Elevator(ElevatorState state) {
        setState(state);
        calledOnGroundFloor = false;
        calledOnFirstFloor = false;
        direction = DirectionType.NONE;
    }

    public void pushCallButtonOnFirstFloor() {
        calledOnFirstFloor = true;
        if (direction == DirectionType.NONE) {
            direction = DirectionType.UP;
        }
    }

    public void pushCallButtonOnGroundFloor() {
        calledOnGroundFloor = true;
        if (direction == DirectionType.NONE) {
            direction = DirectionType.DOWN;
        }
    }

    public void pushButtonToGoToFirstFloor() {
        if (state.getStateInfo().equals("Ground Floor Open")) {
            direction = DirectionType.UP;
        }
    }

    public void pushButtonToGoToGroundFloor() {
        if (state.getStateInfo().equals("First Floor Open")) {
            direction = DirectionType.DOWN;
        }
    }

    public String getStateInfo() {
        return state.getStateInfo();
    }

    void setState(ElevatorState state) {
        history.add(state.getStateInfo());
        this.state = state;
    }

    public void work(){
        while(direction != DirectionType.NONE ){
            state.changeState(this);
        }
    }

    public DirectionType getDirection() {
        return direction;
    }

    public void setDirection(DirectionType direction) {
        this.direction = direction;
    }

    public boolean getCalledOnGroundFloor() { return calledOnGroundFloor; }

    public void setCalledOnGroundFloor(boolean value) {
        this.calledOnGroundFloor = value;
    }

    public boolean getCalledOnFirstFloor() {
        return calledOnFirstFloor;
    }

    public void setCalledOnFirstFloor(boolean value) {
        this.calledOnFirstFloor = value;
    }

    public String getHistory() {
        return history.toString();
    }

}