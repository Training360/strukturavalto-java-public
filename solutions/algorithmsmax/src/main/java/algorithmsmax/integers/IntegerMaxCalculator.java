package algorithmsmax.integers;

import java.util.List;

public class IntegerMaxCalculator {

    public int max(List<Integer> numbers) {
        int max = Integer.MIN_VALUE;
        for (Integer n: numbers) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }
}
