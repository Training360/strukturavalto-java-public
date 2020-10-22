package collectionstreeset;

import java.util.Set;
import java.util.TreeSet;

public class WordFilter {

    public Set<String> filterWords(String[] randomStrings) {
        Set<String> orderedStrings = new TreeSet<String>();
        for (String str : randomStrings) {
            orderedStrings.add(str);
        }
        return orderedStrings;
    }
}
