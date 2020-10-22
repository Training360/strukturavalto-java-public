package methodoverloading.pub;

import methodoverloading.pub.Pub;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class PubTest {

    @Test
    public void constructorTest() {
        //Given
        Pub pub = new Pub("Kurta kocsma", 10, 30);
        //Then
        assertThat(pub.getName(), equalTo("Kurta kocsma"));
        assertThat(pub.getOpenFrom().getHours(), equalTo(10));
        assertThat(pub.getOpenFrom().getMinutes(), equalTo(30));
    }

    @Test
    public void toStringTest() {
        //Given
        Pub pub = new Pub("Kurta kocsma", 10, 30);
        //Then
        assertThat(pub.toString(), equalTo("Kurta kocsma;10:30"));
    }
}