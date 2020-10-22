package immutable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrainerTest {

    @Test
    public void testCreate() {
        Trainer trainer = new Trainer("John Doe", 30, Collections.emptyList());

        assertThat(trainer.getName(), equalTo("John Doe"));
        assertThat(trainer.getAge(), equalTo(30));
    }

    @Test
    public void testCreateWithCourses() {
        List<Course> courses = new ArrayList<>(Arrays.asList(new Course("Math"), new Course("Biology")));
        Trainer trainer = new Trainer("John Doe", 30, courses);

        courses.add(new Course("Art"));
        assertThat(trainer.getCourses().size(), equalTo(2));

        trainer.getCourses().add(new Course("Art"));
        assertThat(trainer.getCourses().size(), equalTo(2));

    }
}
