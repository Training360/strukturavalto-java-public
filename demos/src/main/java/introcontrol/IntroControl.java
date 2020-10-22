package introcontrol;

import java.util.Random;

public class IntroControl {

    public static void main(String[] args) {
        int x = new Random().nextInt(1000);
        if ((x % 2) == 0) {
            System.out.println("Even:" + x);
        }
        else {
            System.out.println("Odd:" + x);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
