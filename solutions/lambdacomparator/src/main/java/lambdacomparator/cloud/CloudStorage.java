package lambdacomparator.cloud;

public class CloudStorage implements Comparable<CloudStorage> {

    private static final int STANDARD_SIZE = 1000;
    private static final int STANDARD_PERIOD = 12;

    private String provider;

    private int space;

    private PayPeriod period;

    private double price;

    public CloudStorage(String provider, int space, PayPeriod period, double price) {
        this(provider, space);
        this.period = period;
        this.price = price;
    }

    public CloudStorage(String provider, int space) {
        this.provider = provider;
        this.space = space;
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return space;
    }

    public PayPeriod getPeriod() {
        return period;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(CloudStorage o) {
        double currentValue = this.period != null ? this.price * STANDARD_PERIOD / this.period.getLength() / this.space * STANDARD_SIZE : 0;
        double otherValue = o.period != null ? o.price * STANDARD_PERIOD / o.period.getLength() / o.space * STANDARD_SIZE : 0;
        return Double.compare(currentValue, otherValue);
    }

}
