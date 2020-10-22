package javabeans;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HumanTest {

    @Test
    public void getSetName() {
        final String name = "Kovács Anna";
        Human human = new Human();
        human.setName(name);

        assertThat(human.getName(), is(name));
    }

    @Test
    public void getSetWeight() {
        final double weight = 62.3;
        Human human = new Human();
        human.setWeight(weight);

        assertThat(human.getWeight(), is(weight));
    }

    @Test
    public void getSetIQ() {
        final int iq = 123;
        Human human = new Human();
        human.setIq(iq);

        assertThat(human.getIq(), is(iq));
    }
}