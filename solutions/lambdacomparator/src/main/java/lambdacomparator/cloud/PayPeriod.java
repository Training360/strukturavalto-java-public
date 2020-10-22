package lambdacomparator.cloud;

public enum PayPeriod {

    MONTHLY(1), ANNUAL(12), LIFETIME(60);

    private int length;

    PayPeriod(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
