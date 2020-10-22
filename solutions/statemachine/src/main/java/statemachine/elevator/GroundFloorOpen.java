package statemachine.elevator;


public class GroundFloorOpen implements ElevatorState {

    public GroundFloorOpen(Elevator elevator){
        elevator.setCalledOnGroundFloor(false);
        if (elevator.getCalledOnFirstFloor()) {
            elevator.setDirection(DirectionType.UP);
        }
        if (elevator.getDirection() == DirectionType.DOWN) {
            elevator.setDirection(DirectionType.NONE);
        }
    }

    @Override
    public void changeState(Elevator elevator) {
        elevator.setState(new GroundFloorClosed());
    }

    @Override
    public String getStateInfo() {
        return  "Ground Floor Open";
    }

}