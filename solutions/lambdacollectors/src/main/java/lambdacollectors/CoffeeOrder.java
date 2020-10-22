package lambdacollectors;

import java.time.LocalDateTime;
import java.util.List;

public class CoffeeOrder {

    private List<Coffee> coffeeList;

    private LocalDateTime dateTime;

    public CoffeeOrder(List<Coffee> coffeeList, LocalDateTime dateTime) {
        this.coffeeList = coffeeList;
        this.dateTime = dateTime;
    }

    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
