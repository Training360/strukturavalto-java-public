package statemachine.elevator;


public class FirstFloorClosed implements ElevatorState {

    @Override
    public void changeState(Elevator elevator) {
        switch (elevator.getDirection()) {
            case UP:
                elevator.setState(new FirstFloorOpen(elevator));
                break;
            case DOWN:
                if (elevator.getCalledOnFirstFloor())
                    elevator.setState(new FirstFloorOpen(elevator));
                else
                    elevator.setState(new GroundFloorClosed());
                break;
        }
    }

    @Override
    public String getStateInfo() {
        return "First Floor Closed";
    }

}