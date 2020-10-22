package introcontrol;

public class IntroControl {

    public int subtractTenIfGreaterThanTen(int number) {
        if (number > 10) {
            return number - 10;
        } else {
            return number;
        }
    }

    public String greetingToJoe(String name) {
        if (name.equals("Joe")) {
            return "Hello Joe";
        } else {
            return "";
        }
    }

    public String describeNumber(int number) {
        if (number == 0) {
            return "zero";
        } else {
            return "not zero";
        }
    }

    public int calculateBonus(int sale) {
        if (sale >= 1_000_000) {
            return sale / 10;
        } else {
            return 0;
        }
    }


    public void printNumbers(int max) {
        for (int i = 0; i <= max; i++) {
            System.out.println(i);
        }
    }

    public void printNumbersBetween(int min, int max) {
        for (int i = min; i <= max; i++) {
            System.out.println(i);
        }
    }

    public void printNumbersBetweenAnyDirection(int a, int b) {
        if (b > a) {
            for (int i = a; i <= b; i++) {
                System.out.println(i);
            }
        } else {
            for (int i = a; i >= b; i--) {
                System.out.println(i);
            }
        }
    }

    public void printOddNumbers(int max) {
        for (int i = 1; i <= max; i = i + 2) {
            System.out.println(i);
        }
    }

    public int calculateConsumption(int prev, int next) {
        if (prev <= next) {
            return next - prev;
        } else {
            return 10_000 - prev + next;
        }
    }

}

