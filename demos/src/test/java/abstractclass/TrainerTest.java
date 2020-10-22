package abstractclass;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrainerTest {

    @Test
    public void testCreate() {
        Trainer trainer = new Trainer("John Doe", Arrays.asList(new Course("Biology")));
        assertThat(trainer.getName(), equalTo("John Doe"));
        assertThat(trainer.getCourses().size(), equalTo(1));
    }

    @Test
    public void testWork() {
        List<Course> courses = Arrays.asList(new Course("Biology"), new Course("Math"));
        assertThat(courses.get(0).isTaken(), equalTo(false));
        Human human = new Trainer("John Doe", courses);
        human.work();

        assertThat(courses.get(0).isTaken(), equalTo(true));
        assertThat(courses.get(1).isTaken(), equalTo(true));
    }
}
