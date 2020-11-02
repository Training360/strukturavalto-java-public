package methodparam;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrainerTest {

    @Test
    public void createTrainerData(){
        TrainerData trainerData=  new TrainerData("John Doe", 30, Trainer.Answer.NO);

        assertEquals(30, trainerData.getAge());
        assertEquals("John Doe", trainerData.getName());
        assertEquals(Trainer.Answer.NO, trainerData.getAnswer());

    }


    @Test
    public void testChangeData() {
        Trainer trainer = new Trainer();
        trainer.changeData(new TrainerData("John Doe", 30, Trainer.Answer.NO));

        assertEquals(30, trainer.getAge());
        assertEquals("John Doe", trainer.getName());

    }

    @Test
    public void trainerPropertiesTest(){
        Trainer trainer = new Trainer();

        trainer.setName("John Doe");
        trainer.setAge(30);
        trainer.setCourses(Arrays.asList(new Course("Java")));

        assertEquals(30, trainer.getAge());
        assertEquals("John Doe", trainer.getName());
        assertEquals("Java", trainer.getCourses().get(0).getName());

    }

    @Test
    public void wrongAgeTest(){
        Trainer trainer = new Trainer();

        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            trainer.setAge(1);
        });
        assertEquals("Invalid age: 1", e.getMessage());
    }

}
