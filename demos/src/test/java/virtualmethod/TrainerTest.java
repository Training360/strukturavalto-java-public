package virtualmethod;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrainerTest {

    @Test
    public void testFreeTimeByHuman() {
        Human human = new Human("John Doe");
        assertThat(human.getFreeTime(), equalTo(4));
    }

    @Test
    public void testFreeTimeByTrainer() {
        Trainer trainer = new Trainer("John Doe", Arrays.asList(new Course("Course1")));
        assertThat(trainer.getFreeTime(), equalTo(3));

        Human human = new Trainer("John Doe", Arrays.asList(new Course("Course1")));
        assertThat(human.getFreeTime(), equalTo(3));
    }

    @Test
    public void testFreeTimeLimit() {
        Trainer trainer = new Trainer("John Doe",
                Arrays.asList(new Course("Course1"), new Course("Course2"),
                        new Course("Course3"), new Course("Course4"),
                        new Course("Course5")));
        assertThat(trainer.getFreeTime(), equalTo(0));
    }

}
