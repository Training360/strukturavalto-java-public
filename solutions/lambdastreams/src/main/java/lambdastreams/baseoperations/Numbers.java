package lambdastreams.baseoperations;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Numbers {

    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Optional<Integer> min(){
        return numbers.stream().min(Comparator.naturalOrder());
    }

    public Integer sum() {
        return numbers.stream().reduce(0, (a,b) -> a+b);
    }

    public Set<Integer> getDistinctElements(){
        return numbers.stream().collect(Collectors.toSet());
    }

    public boolean isAllPositive(){
        return numbers.stream().allMatch(x -> x > 0);
    }
}
