package finalmodifier;

import static finalmodifier.CircleCalculator.PI;

public class PiMain {

    public static void main(String[] args) {

        System.out.println(PI);

        CircleCalculator circleCalculator = new CircleCalculator();

        System.out.println(circleCalculator.calculateArea(10));
        System.out.println(circleCalculator.calculatePerimeter(10));

        CylinderCalculator cylinderCalculator = new CylinderCalculator();

        System.out.println(cylinderCalculator.calculateVolume(10, 20));
        System.out.println(cylinderCalculator.calculateSurfaceArea(10, 20));

        CylinderCalculatorBasedOnCircle cylinderCalculatorBasedOnCircle = new CylinderCalculatorBasedOnCircle();

        System.out.println(cylinderCalculatorBasedOnCircle.calculateVolume(10, 20));
        System.out.println(cylinderCalculatorBasedOnCircle.calculateSurfaceArea(10, 20));

    }
}
