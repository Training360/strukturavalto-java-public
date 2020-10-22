package constructoroverloading;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrainerTest {

    @Test
    public void testCreate() {
        Trainer trainer = new Trainer();
        assertThat(trainer.getName(), equalTo("anonymous"));
        assertThat(trainer.getAge(), equalTo(20));
    }

    @Test
    public void testCreateWithName() {
        Trainer trainer = new Trainer("John Doe");
        assertThat(trainer.getName(), equalTo("John Doe"));
        assertThat(trainer.getAge(), equalTo(20));
    }

    @Test
    public void testCreateWithNameAndAge() {
        Trainer trainer = new Trainer("John Doe", 30);
        assertThat(trainer.getName(), equalTo("John Doe"));
        assertThat(trainer.getAge(), equalTo(30));
    }
}
