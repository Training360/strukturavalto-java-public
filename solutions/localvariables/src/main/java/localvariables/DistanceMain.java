package localvariables;

public class DistanceMain {

    public static void main(String[] args) {
        Distance distance = new Distance(100.50, false);
        System.out.println(distance.getDistanceInKm() + " " + distance.isExact());
        int integerPart = (int) distance.getDistanceInKm();
        System.out.println(integerPart);
    }
}
