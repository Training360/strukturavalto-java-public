package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {

    public List<Integer> find(List<Integer> elements) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (elements.get(i).equals(elements.get(j))) {
                    result.add(elements.get(i));
                    break;
                }
            }
        }
        return result;
    }
}
