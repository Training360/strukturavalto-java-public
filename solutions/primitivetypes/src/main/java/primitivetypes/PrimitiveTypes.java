package primitivetypes;

public class PrimitiveTypes {

    public static final int NUMBER_OF_BITS = 32;

    public String toBinaryString(int n) {
        String s = "";
        for (int number = Math.abs(n); number > 0; ) {
            int bit = number % 2;
            s = bit + "" + s;
            number = number / 2;
        }
        int zeros = NUMBER_OF_BITS - s.length();
        for (int i = 0; i < zeros; i++) {
            s = "0" + s;
        }
        if (n < 0) {
            s = toTwoComplementer(s);
        }
        return s;
    }

    private String toTwoComplementer(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            res += flip(c);
        }
        return addOne(res);
    }

    private String addOne(String s) {
        String res = "";
        boolean flip = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (flip) {
                c = flip(c);
            }
            if (c == '1') {
                flip = false;
            }
            res = c + res;
        }
        return res;
    }

    private char flip(char c) {
        return c == '0' ? '1' : '0';
    }
}
