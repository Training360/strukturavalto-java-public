package hu.nive.ujratervezes.zarovizsga.uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {
    public List<Character> uniqueChars(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Null");
        }
        List<Character> chars = new ArrayList<>();
        for (char c: s.toCharArray()) {
            if (!chars.contains(c)) {
                chars.add(c);
            }
        }
        return chars;
    }
}
