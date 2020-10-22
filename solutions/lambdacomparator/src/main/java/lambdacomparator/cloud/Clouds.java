package lambdacomparator.cloud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Clouds {

    public CloudStorage alphabeticallyFirst(List<CloudStorage> storages) {
        return Collections.min(storages, Comparator.comparing(CloudStorage::getProvider, String::compareToIgnoreCase));
    }

    public CloudStorage bestPriceForShortestPeriod(List<CloudStorage> storages) {
        return Collections.min(storages, Comparator.comparing(CloudStorage::getPeriod, Comparator.nullsFirst(Comparator.comparingInt(PayPeriod::getLength))).thenComparingDouble(CloudStorage::getPrice));
    }

    public List<CloudStorage> worstOffers(List<CloudStorage> storages) {
        List<CloudStorage> copyStorages = new ArrayList<>(storages);
        copyStorages.sort(Comparator.reverseOrder());
        return copyStorages.subList(0, Math.min(copyStorages.size(), 3));
    }
}
