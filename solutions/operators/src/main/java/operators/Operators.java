package operators;

public class Operators {

    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    public int multiplyByPowerOfTwo(int number, int power) {
        return number << power;
    }
 
    public void cannotConvert() {
        int i = -1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        int j = Integer.parseInt(s, 2);
        System.out.println(j);
    }

    public void convert() {
        int i = -1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        int j = Long.valueOf(s, 2).intValue();
        System.out.println(j);
    }
}
