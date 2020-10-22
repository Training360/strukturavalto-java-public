package algorithmsdecision;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrainerTest {

    @Test
    public void testGetAge() {
        Trainer trainer = new Trainer("Zsofia", 21);

        assertThat(trainer.getAge(), is(21));
    }

}
