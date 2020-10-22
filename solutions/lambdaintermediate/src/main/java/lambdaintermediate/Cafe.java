package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {

    private List<CoffeeOrder> orders;

    public Cafe() {
        orders = new ArrayList<>();
    }

    public Cafe(List<CoffeeOrder> orders) {
        this.orders = orders;
    }

    public void addOrder(CoffeeOrder order){
        orders.add(order);
    }

    public BigDecimal getTotalIncome(){
        return orders.stream()
                .flatMap(x -> x.getCoffeeList().stream())
                .map(c -> c.getPrice())
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b), (x, y) -> x.add(y)).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalIncome(LocalDate date) {
        return orders.stream()
                .filter(order -> order.getDateTime().toLocalDate().equals(date))
                .flatMap(x -> x.getCoffeeList().stream())
                .map(c -> c.getPrice())
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b), (x, y) -> x.add(y)).setScale(2, RoundingMode.HALF_UP);
    }

    public long getNumberOfCoffee(CoffeeType type) {
        return orders.stream()
                .flatMap(x -> x.getCoffeeList().stream())
                .map(a -> a.getType())
                .filter(type::equals)
                .count();
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from){
        return orders.stream()
                .filter(x -> x.getDateTime().isAfter(from))
                .collect(Collectors.toList());
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date) {
        return orders.stream()
                .filter(x -> x.getDateTime().toLocalDate().equals(date))
                .sorted((a, b) -> a.getDateTime().compareTo(b.getDateTime()))
                .limit(5)
                .collect(Collectors.toList());
    }
}
