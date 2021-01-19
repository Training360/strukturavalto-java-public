package exam02;

import java.util.Arrays;

public class ArraySelector {

    public String selectEvens(int[] values) {
        if (values.length < 1) {
            return "";
        }
        int[] newValues = new int[(int)Math.round(values.length / 2.0)];
        for (int i = 0; i < values.length; i++) {
            if (i % 2 == 0) {
                newValues[i / 2] = values[i];
            }
        }
        return Arrays.toString(newValues);
    }
}
