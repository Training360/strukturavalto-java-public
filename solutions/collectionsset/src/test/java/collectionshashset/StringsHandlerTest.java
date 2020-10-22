package collectionshashset;


import helper.RandomStringGenerator;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringsHandlerTest {

    @Test
    public void checkNumberOfElementsInSet() {
        Collection<String> testCollection = new RandomStringGenerator().createStrings(4, 500_000);

        //When
        Set<String> strings = new StringsHandler().filterUniqueStrings(testCollection);

        //Then
        assertThat(strings.size() < testCollection.size(), is(true));
    }

    @Test
    public void checkNumberOfIdenticalElementsInSets() {
        //Given
        Set<String> strings = new HashSet<>(new RandomStringGenerator().createStrings(4, 500_000));
        Set<String> anotherStrings = new HashSet<>(new RandomStringGenerator().createStrings(4, 500_000));
        int a = strings.size();
        int b = anotherStrings.size();

        //When
        strings = new StringsHandler().selectIdenticalStrings(strings, anotherStrings);

        //Then
        assertThat(strings.size() < (a + b), is(true));
    }
}
