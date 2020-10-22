package interfacestaticmethods;

import java.util.List;

public interface Valued {

    static double totalValue(List<Valued> items) {
        double result = 0;
        for (Valued valued : items) {
            result += valued.getValue();
        }
        return result;
    }

    double getValue();
}
