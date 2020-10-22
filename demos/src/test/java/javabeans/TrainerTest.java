package javabeans;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TrainerTest {

    @Test
    public void createTrainer() {
        Trainer trainer = new Trainer("John Doe", true);
        assertThat(trainer.getName(), equalTo("John Doe"));
        assertThat(trainer.isActive(), is(true));
    }

    @Test
    public void setTrainer() {
        Trainer trainer = new Trainer("John Doe", true);
        trainer.setName("Jack Doe");
        trainer.setActive(false);
        assertThat(trainer.getName(), equalTo("Jack Doe"));
        assertThat(trainer.isActive(), is(false));
    }
}
