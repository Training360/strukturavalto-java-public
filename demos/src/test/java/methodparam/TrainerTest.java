package methodparam;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TrainerTest {


    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void createTrainerData(){
        TrainerData trainerData=  new TrainerData("John Doe", 30, Trainer.Answer.NO);

        assertThat(trainerData.getAge(),is(30));
        assertThat(trainerData.getName(),is("John Doe"));
        assertThat(trainerData.getAnswer(),is(Trainer.Answer.NO));

    }


    @Test
    public void testChangeData() {
        Trainer trainer = new Trainer();
        trainer.changeData(new TrainerData("John Doe", 30, Trainer.Answer.NO));

        assertThat(trainer.getAge(),is(30));
        assertThat(trainer.getName(),is("John Doe"));

    }

    @Test
    public void trainerPropertiesTest(){
        Trainer trainer = new Trainer();

        trainer.setName("John Doe");
        trainer.setAge(30);
        trainer.setCourses(Arrays.asList(new Course("Java")));

        assertThat(trainer.getAge(),is(30));
        assertThat(trainer.getName(),is("John Doe"));
        assertThat(trainer.getCourses().get(0).getName(),is("Java"));

    }

    @Test
    public void wrongAgeTest(){
        Trainer trainer = new Trainer();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid age: 1");
        trainer.setAge(1);

    }

}
