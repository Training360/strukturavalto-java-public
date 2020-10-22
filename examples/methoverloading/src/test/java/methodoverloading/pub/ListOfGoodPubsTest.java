package methodoverloading.pub;

import methodoverloading.pub.ListOfGoodPubs;
import methodoverloading.pub.Pub;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ListOfGoodPubsTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void emptyPubListShouldThrowException() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Pub list is empty!");
        // When
        new ListOfGoodPubs(new ArrayList<>());
    }

    @Test
    public void testFindTheBest() {

        ListOfGoodPubs goodPubs = new ListOfGoodPubs(Arrays.asList(
                new Pub("A két rablóhoz", 12, 20),
                new Pub("Kurta kocsma", 9, 0),
                new Pub("Kings", 23, 0),
                new Pub("Fehér ló", 22, 30),
                new Pub("Fekete macska", 23, 30)
        ));

        assertThat(goodPubs.findTheBest().toString(), equalTo("Kurta kocsma;9:0"));
    }
}