package array;

public class ArrayMain {

    public static void main(String[] args) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thirsday", "Friday", "Saturday", "Sunday"};

        System.out.println(days[1]);
        System.out.println(days.length);

        int[] powersOfTwo = new int[5];
        powersOfTwo[0] = 1;
        for (int i = 1; i < powersOfTwo.length; i++) {
            powersOfTwo[i] = powersOfTwo[i - 1] * 2;
        }

        for (int i = 0; i < powersOfTwo.length; i++) {
            System.out.print(powersOfTwo[i] + " ");
        }

        System.out.println();
        
        boolean[] bools = new boolean[6];

        for (int i = 1; i < bools.length; i++) {
            bools[i] = !bools[i - 1];
        }

        for (int i = 0; i < bools.length; i++) {
            System.out.print(bools[i] + " ");
        }
    }
}
