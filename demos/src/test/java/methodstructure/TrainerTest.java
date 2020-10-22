package methodstructure;

import org.junit.Test;

public class TrainerTest {

    @Test
    public void testCreate() {
        Trainer trainer = new Trainer("John Doe");
        trainer.getName();
    }

    @Test
    public void testAdd() {
        Trainer trainer = new Trainer("John Doe");
        trainer.addCourse("Course1");
    }

    @Test
    public void testFind() {
        Trainer trainer = new Trainer("John Doe");
        trainer.findCoursesBetween('a', 'z');
    }
}
