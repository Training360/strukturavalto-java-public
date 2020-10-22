package statemachine.elevator;


public class GroundFloorClosed implements ElevatorState {


    @Override
    public void changeState(Elevator elevator) {
        switch (elevator.getDirection()) {
            case UP:
                if (elevator.getCalledOnGroundFloor())
                    elevator.setState(new GroundFloorOpen(elevator));
                else
                    elevator.setState(new FirstFloorClosed());
                break;
            case DOWN:
                elevator.setState(new GroundFloorOpen(elevator));
                break;
        }
    }

    @Override
    public String getStateInfo() {
        return "Ground Floor Closed";
    }

}