package collectionslinkedlist;

import java.util.*;


public class Draw {

    private List<Integer> createNumberPool(int maxNumber) {
        List<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= maxNumber; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        return numbers;
    }

    public Set<Integer> drawNumbers(int drawCount, int maxNumber) throws IllegalArgumentException {

        if (maxNumber <= drawCount) {
            throw new IllegalArgumentException("drawCount must be less then maxNumber!");
        }

        return new TreeSet<>(createNumberPool(maxNumber));
    }
}
