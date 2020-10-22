package collectionstreeset;


import org.junit.Test;

import java.util.Set;
import java.util.SortedSet;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WordFilterTest {

    public final static String[] randomStrings = new String[]{"xyz", "cde", "klm", "cde"};

    @Test
    public void checkSetSizeAndOrder() {
        //When
        Set<String> testSet = new WordFilter().filterWords(randomStrings);
        //Then
        assertThat(testSet.size(), is(3));
        assertThat(((SortedSet<String>) testSet).first(), equalTo("cde"));
        assertThat(((SortedSet<String>) testSet).last(), equalTo("xyz"));
    }
}
