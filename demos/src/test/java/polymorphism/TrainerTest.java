package polymorphism;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class TrainerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCreate() {
        Trainer trainer = new Trainer("John Doe", Arrays.asList(new Course("Course1")));

        assertThat(trainer, instanceOf(Trainer.class));
        assertThat(trainer, instanceOf(Human.class));
        assertThat(trainer, instanceOf(Object.class));
        assertThat(trainer, instanceOf(HasName.class));

        Object object = new Trainer("John Doe", Arrays.asList(new Course("Course1")));
        assertThat(object, instanceOf(Trainer.class));
        assertThat(object, instanceOf(Human.class));
        assertThat(object, instanceOf(Object.class));
        assertThat(object, instanceOf(HasName.class));

        Human human = new Trainer("John Doe", Arrays.asList(new Course("Course1")));
        assertThat(human, instanceOf(Trainer.class));
        assertThat(human, instanceOf(Human.class));
        assertThat(human, instanceOf(Object.class));
        assertThat(human, instanceOf(HasName.class));

        HasName hasName = new Trainer("John Doe", Arrays.asList(new Course("Course1")));
        assertThat(hasName, instanceOf(Trainer.class));
        assertThat(hasName, instanceOf(Human.class));
        assertThat(hasName, instanceOf(Object.class));
        assertThat(hasName, instanceOf(HasName.class));
    }

    @Test
    public void testConvert() {
        Trainer trainer = new Trainer("John Doe", Arrays.asList(new Course("Course1")));
        Human human = trainer;
        Object object = trainer;
        HasName hasName = trainer;
    }

    @Test
    public void testExplicitConvert() {
        Object object = new Trainer("John Doe", Arrays.asList(new Course("Course1")));
        Trainer trainer = (Trainer) object;
    }

    @Test
    public void testExplicitConvertCannotWork() {
        expectedException.expect(ClassCastException.class);
        Human human = new Human("John Doe");
        Trainer trainer = (Trainer) human;
    }
}
