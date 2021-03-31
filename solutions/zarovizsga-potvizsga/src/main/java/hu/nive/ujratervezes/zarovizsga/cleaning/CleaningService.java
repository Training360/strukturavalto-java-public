package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();


    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public int cleanAll() {
        int price = 0;
        for (Cleanable c : cleanables) {
            price += c.clean();
        }
        cleanables.clear();
        return price;
    }


    public int cleanOnlyOffices() {
        int price = 0;
        Iterator<Cleanable> iterator = cleanables.iterator();
        while (iterator.hasNext()) {
            Cleanable cleanable = iterator.next();
            if (cleanable.getType() == BuildingType.OFFICE) {
                price += cleanable.clean();
                iterator.remove();
            }
        }
        return price;
    }

    public List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> result = new ArrayList<>();

        for (Cleanable c : cleanables) {
            if (c.getAddress().contains(address)) {
                result.add(c);
            }
        }
        return result;
    }

    public String getAddresses() {
        if (cleanables.size() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cleanables.get(0).getAddress());

        for (int i = 1; i < cleanables.size(); i++) {
            sb.append(", ").append(cleanables.get(i).getAddress());
        }
        return sb.toString();


    }


    public List<Cleanable> getCleanables() {
        return new ArrayList<>(cleanables);
    }


}
