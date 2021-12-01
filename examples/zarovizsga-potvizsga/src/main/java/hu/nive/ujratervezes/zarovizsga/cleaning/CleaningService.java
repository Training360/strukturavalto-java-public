package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public int cleanAll() {
        int sum = cleanables.stream()
                .mapToInt(Cleanable::clean)
                .sum();
        cleanables.clear();
        return sum;
    }

    public int cleanOnlyOffices() {
        List<Cleanable> offices = cleanables.stream()
                .filter(c -> c instanceof Office)
                .collect(Collectors.toList());

        int sum = offices.stream()
                .mapToInt(Cleanable::clean)
                .sum();

        cleanables.removeAll(offices);

        return sum;
    }

    public List<Cleanable> findByAddressPart(String address) {
        return cleanables.stream()
                .filter(c -> c.getAddress().contains(address))
                .collect(Collectors.toList());
    }

    public String getAddresses() {
        return cleanables.stream()
                .map(Cleanable::getAddress)
                .collect(Collectors.joining(", "));
    }
}
