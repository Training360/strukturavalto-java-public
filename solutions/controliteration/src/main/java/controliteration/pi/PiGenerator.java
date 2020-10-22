package controliteration.pi;

import java.math.BigDecimal;

public class PiGenerator {

    private static final String PI_POET = "Nem a régi s durva közelítés,\n" +
            "Mi szótól szóig így kijön\n" +
            "Betűiket számlálva.\n" +
            "Ludolph eredménye már,\n" +
            "Ha itt végezzük húsz jegyen.\n" +
            "De rendre kijő még tíz pontosan,\n" +
            "Azt is bízvást ígérhetem.\n" +
            "\t";
    public static final String DECIMAL_SEPARATOR = ".";

    public String getPi() {
        String s = "";
        int counter = 0;
        for (int i = 0; i < PI_POET.length(); i++) {
            if (counter != 0 && !Character.isAlphabetic(PI_POET.charAt(i))) {
                s += counter;
                if (s.length() == 1) {
                    s += DECIMAL_SEPARATOR;
                }
                counter = 0;
            }
            if (Character.isAlphabetic(PI_POET.charAt(i))) {
                counter ++;
            }
        }
        return s;
    }
}
