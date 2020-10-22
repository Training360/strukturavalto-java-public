package localvariables;

public class Distance {

    private double distanceInKm;

    private boolean exact;

    public Distance(double distanceInKm, boolean exact) {
        this.distanceInKm = distanceInKm;
        this.exact = exact;
    }

    public double getDistanceInKm() {
        return distanceInKm;
    }

    public boolean isExact() {
        return exact;
    }
}
