package lambdaprimitives;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;

public class SportGadgetStore {

    private List<Product> products;

    public SportGadgetStore(List<Product> products) {
        this.products = products;
    }

    public int getNumberOfProducts() {
        return products.stream().mapToInt(x -> x.getPieces()).sum();
    }

    public double getAveragePrice() {
        OptionalDouble average = products.stream().mapToDouble(x -> x.getPrice()).average();
        if (average.isPresent()){
            return average.getAsDouble();
        }
        return 0;
    }

    public String getExpensiveProductStatistics(double minPrice) {
        IntSummaryStatistics statistics = products.stream().filter(x -> x.getPrice() > minPrice).mapToInt(x -> x.getPieces()).summaryStatistics();
        if(statistics.getCount() > 0){
            StringBuilder sb = new StringBuilder("Összesen ")
                                .append(statistics.getCount())
                                .append(" féle termék, amelyekből minimum ")
                                .append(statistics.getMin())
                                .append(" db, maximum ")
                                .append(statistics.getMax())
                                .append(" db, összesen ")
                                .append(statistics.getSum())
                                .append(" db van.");
            return sb.toString();
        }
        return "Nincs ilyen termék.";
    }
}
