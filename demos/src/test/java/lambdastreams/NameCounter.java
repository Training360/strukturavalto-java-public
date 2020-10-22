package lambdastreams;

public class NameCounter {

    private int threePartName = 0;

    private int twoPartName = 0;

    public NameCounter() {
    }

    public NameCounter(int threePartName, int twoPartName) {
        this.threePartName = threePartName;
        this.twoPartName = twoPartName;
    }

    public NameCounter add(Employee employee) {
        if (employee.getName().split(" ").length == 2) {
            return new NameCounter(threePartName, twoPartName + 1);
        }
        else {
            return new NameCounter(threePartName + 1, twoPartName);
        }
    }

    public NameCounter add(NameCounter other) {
        return new NameCounter(threePartName + other.threePartName,
                twoPartName + other.twoPartName);
    }

    public int getThreePartName() {
        return threePartName;
    }

    public int getTwoPartName() {
        return twoPartName;
    }
}
