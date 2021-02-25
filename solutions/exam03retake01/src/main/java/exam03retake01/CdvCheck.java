package exam03retake01;

import java.util.Arrays;

public class CdvCheck {

    private static final int LENGTH = 10;

    public boolean check(String s) {
        if (s.length() != LENGTH || notNumber(s)) {
            throw new IllegalArgumentException("Not a tax number");
        }

        int sum = 0;
        for (int i = 0; i < LENGTH - 1; i++) {
            //int digit = Integer.parseInt(s.substring(i, i + 1));
            try {
                int digit = Integer.parseInt(Character.toString(s.charAt(i)));
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("Not ...");
            }
//            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
//                throw new IllegalArgumentException("Not ...");
//            }
            int digit = s.charAt(i) - '0';
            sum += digit * (i + 1);
        }
        int lastDigit = s.charAt(LENGTH - 1) - '0';
//        System.out.println(lastDigit);
//        System.out.println(sum % 11);
        return sum % 11 == lastDigit;
    }

    private boolean notNumber(String s) {
        try {
            //System.out.println(Integer.MAX_VALUE);
            Long.parseLong(s);
            return false;
        }
        catch (NumberFormatException ne) {
            return true;
        }
    }

    public static void main(String[] args) {
        new CdvCheck().check("8365670003");
    }
}
