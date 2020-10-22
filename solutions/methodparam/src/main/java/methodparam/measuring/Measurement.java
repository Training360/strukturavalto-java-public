package methodparam.measuring;

public class Measurement {

    private double[] values;

    public Measurement(double[] values) {
        this.values = values;
    }

    public int findFirstIndexInLimit(int lower, int upper) {
        for (int j = 0; j < values.length; j++) {
            if (lower < values[j] && values[j] < upper)
                return j;
        }
        return -1;
    }

    public double minimum() {
        double min = values[0];
        for (int j = 1; j < values.length; j++) {
            if (values[j] < min) {
                min = values[j];
            }
        }
        return min;
    }

    public double maximum() {
        double max = values[0];
        for (int j = 1; j < values.length; j++) {
            if (values[j] > max)
                max = values[j];
        }
        return max;
    }

    public ExtremValues minmax() {
        return new ExtremValues(minimum(), maximum());
    }

}
