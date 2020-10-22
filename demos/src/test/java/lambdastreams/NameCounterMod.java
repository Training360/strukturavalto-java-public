package lambdastreams;

public class NameCounterMod {

    private int threePartName = 0;

    private int twoPartName = 0;

    public NameCounterMod() {
    }

    public NameCounterMod(int threePartName, int twoPartName) {
        this.threePartName = threePartName;
        this.twoPartName = twoPartName;
    }

    public void add(Employee employee) {
        if (employee.getName().split(" ").length == 2) {
            twoPartName ++;
        }
        else {
            threePartName ++;
        }
    }

    public void add(NameCounterMod other) {
        this.twoPartName += other.twoPartName;
        this.threePartName += other.threePartName;
    }

    public int getThreePartName() {
        return threePartName;
    }

    public int getTwoPartName() {
        return twoPartName;
    }
}
