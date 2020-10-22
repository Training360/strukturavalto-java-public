package statemachine.elevator;

public  interface  ElevatorState{
    void changeState(Elevator elevator);
    String getStateInfo();
}