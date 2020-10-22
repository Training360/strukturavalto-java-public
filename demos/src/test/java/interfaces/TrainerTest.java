package interfaces;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TrainerTest {

    @Test
    public void testHasName() {
        List<HasName> withNames = new ArrayList<>();
        withNames.add(new Course("Course1"));
        withNames.add(new Trainer("John Doe"));

        List<String> names = new ArrayList<>();
        for (HasName withName: withNames) {
            names.add(withName.getName());
        }
        assertThat(names, equalTo(Arrays.asList("Course1", "John Doe")));
    }

    @Test
    public void testCanWork() {
        CanWork trainer = new Trainer("John Doe");
        trainer.work();
        assertThat(trainer.isFinished(), is(true));
    }

}
