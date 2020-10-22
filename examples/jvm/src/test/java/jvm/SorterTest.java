package jvm;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SorterTest {

    @Test
    public void sort() {
        Sorter sorter = new Sorter();
        List<Integer> list = sorter.createListAndSort(20);

        assertThat(list.size(), equalTo(20));
        for (int i = 0; i < list.size() - 1; i++) {
            assertThat(list.get(i) <= list.get(i + 1), is(true));
        }
    }
}
