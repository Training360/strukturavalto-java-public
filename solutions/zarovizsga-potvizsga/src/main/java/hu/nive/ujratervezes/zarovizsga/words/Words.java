package hu.nive.ujratervezes.zarovizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {

        if (s == null) {
            return false;
        }

        int countDigits = 0;
        //int countOther=0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                countDigits++;
            }
        }

        return 2 * countDigits - s.length() > 0;
    }

}
