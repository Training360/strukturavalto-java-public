package collectionsequalshash;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class EqualsTest {

    @Test
    public void testEquals() {
        String s = new String("John");
        String s2 = new String("John");
        assertThat(s.equals(s2), equalTo(true));

        Trainer trainer = new Trainer("John Doe", 2000);
        Trainer trainer2 = new Trainer("John Doe", 1990);
        assertThat(trainer.equals(trainer2), equalTo(false));

        Trainer trainer3 = new Trainer("John Doe", 2000);
        assertThat(trainer.equals(trainer3), equalTo(true));

        List<Integer> l = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(1, 2, 3);

        assertThat(l.equals(l2), equalTo(true));
    }

    @Test
    public void testHashCode() {
        Trainer trainer = new Trainer("John Doe", 1990);
        Trainer trainer1 = new Trainer("John Doe", 1990);
        assertThat(trainer.equals(trainer1), equalTo(true));
        assertThat(trainer.hashCode() == trainer1.hashCode(), equalTo(true));

        Trainer trainer2 = new Trainer("John Doe", 2000);
        assertThat(trainer.equals(trainer2), equalTo(false));
    }
}
