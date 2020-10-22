package defaultconstructor;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TrainerTest {

    @Test
    public void testCreate() {
        Trainer trainer = new Trainer("John Doe");
        assertThat(trainer.getName(), equalTo("John Doe"));
    }
}
