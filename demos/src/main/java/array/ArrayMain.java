package array;

public class ArrayMain {

    public static void main(String[] args) {
        String[] days = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};

        System.out.println(days[1]);
        System.out.println("Array length: " + days.length);

        int[] powers = new int[5];
        powers[0] = 1;
        for (int i = 1; i < powers.length; i++) {
            powers[i] = powers[i - 1] * 2;
        }

        for (int power: powers) {
            System.out.println(power);
        }

        boolean[] booleans = new boolean[6];
        booleans[0] = false;
        for (int i = 1; i < booleans.length; i++) {
            booleans[i] = !booleans[i - 1];
        }

        for (boolean b: booleans) {
            System.out.println(b);
        }
    }
}
