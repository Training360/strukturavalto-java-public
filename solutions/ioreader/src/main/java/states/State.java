package states;

public class State {

    private String stateName;
    private String capital;

    public State(String stateName, String capital) {
        this.stateName = stateName;
        this.capital = capital;
    }


    public String getStateName() {
        return stateName;
    }

    public String getCapital() {
        return capital;
    }
}
