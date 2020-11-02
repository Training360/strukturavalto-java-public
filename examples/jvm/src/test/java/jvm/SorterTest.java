package jvm;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SorterTest {

    @Test
    public void sort() {
        Sorter sorter = new Sorter();
        List<Integer> list = sorter.createListAndSort(20);

        assertEquals(20, list.size());
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }
}
