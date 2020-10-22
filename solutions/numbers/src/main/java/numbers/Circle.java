package numbers;

public class Circle {

    private int diameter;

    private double pi;

    public Circle(int diameter) {
        this.diameter = diameter;
        pi = 3.14;
    }

    public double perimeter() {
        return diameter * pi;
    }

    public double area() {
        return (double) diameter * diameter / 4 * pi;
    }
}
