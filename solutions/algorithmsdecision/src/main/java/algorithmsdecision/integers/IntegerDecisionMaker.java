package algorithmsdecision.integers;

import java.util.List;

public class IntegerDecisionMaker {

    public boolean containsGreaterThan(List<Integer> numbers, int min) {
        for (Integer i: numbers) {
            if (i > min) {
                return true;
            }
        }
        return false;
    }

    public boolean containsLowerThan(List<Integer> numbers, int max) {
        boolean contains = false;
        int i = 0;
        while (i < numbers.size() && !contains) {
            if (numbers.get(i) < max) {
                contains = true;
            }
            i++;
        }
        return contains;
    }
}
