package exceptionresource;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrainerReaderTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testNull() {
        expectedException.expect(NullPointerException.class);
        TrainerReader trainerReader = new TrainerReader(null);
        trainerReader.read();
    }

    @Test
    public void testInvalidLine() {
        expectedException.expect(IllegalArgumentException.class);
        TrainerReader trainerReader = new TrainerReader("John Doe");
        trainerReader.read();
    }

    @Test
    public void testEmptyName() {
        expectedException.expect(IllegalArgumentException.class);
        TrainerReader trainerReader = new TrainerReader(";30");
        trainerReader.read();
    }

    @Test
    public void testInvalidNumber() {
        expectedException.expect(IllegalArgumentException.class);
        TrainerReader trainerReader = new TrainerReader("John Doe;abc");
        trainerReader.read();
    }

    @Test
    public void testValid() {
        TrainerReader trainerReader = new TrainerReader("John Doe;30");
        List<Trainer> trainers = trainerReader.read();

        assertThat(trainers.size(), equalTo(1));
        assertThat(trainers.get(0).getName(), equalTo("John Doe"));
        assertThat(trainers.get(0).getAge(), equalTo(30));
    }

    @Test
    public void testValidMoreLines() {
        TrainerReader trainerReader = new TrainerReader("John Doe;30\nJane Doe;20");
        List<Trainer> trainers = trainerReader.read();

        assertThat(trainers.size(), equalTo(2));
        assertThat(trainers.get(0).getName(), equalTo("John Doe"));
        assertThat(trainers.get(1).getAge(), equalTo(20));
    }
}
