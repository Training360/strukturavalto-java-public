package interfacerules;

public class Trainer implements HasName, CanWork {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void doWork() {
        //
    }
}
