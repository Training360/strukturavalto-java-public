package finalmodifier;

public class CylinderCalculator {

    public double calculateVolume(double r, double h) {
        return r * r * CircleCalculator.PI * h;
    }

    public double calculateSurfaceArea(double r, double h) {
        return (2 * CircleCalculator.PI * r * r ) + (h * CircleCalculator.PI * 2 * r);
    }
}
