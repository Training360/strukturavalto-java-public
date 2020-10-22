package stringbasic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringCreatorTest {

    @Test
    public void sameStringsInPoolShouldBeTheSameObject() {
        //Given
        StringCreator sc = new StringCreator();

        //Then
        assertThat(sc.createStringForPool() == sc.createStringForPool(), is(true));
        assertThat(sc.createStringForHeap() == sc.createStringForHeap(), is(false));
        assertThat(sc.createStringForPool().equals(sc.createStringForHeap()), is(true));
    }

    @Test
    public void sameStringsShouldBeTheSameByCanonicalRepresentation(){
        //Given
        StringCreator sc = new StringCreator();

        //Then
        assertThat(sc.createStringForHeap().intern() == sc.createStringForHeap().intern(), is(true));
        assertThat(sc.createStringForHeap().intern() == sc.createStringForPool().intern(), is(true));
    }
}
