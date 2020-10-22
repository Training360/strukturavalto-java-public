package isahasa;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TrainerTest {

    @Test
    public void testWorkHasCalled() {
        WorkStub workStub = new WorkStub();
        Trainer trainer = new Trainer(workStub);
        trainer.doWork();
        assertThat(workStub.isCalled(), is(true));
    }

    @Test
    public void testHasNoWork() {
        Trainer trainer = new Trainer(new HasNoWork());
        assertThat(trainer.doWork(), equalTo(""));
    }

    @Test
    public void testCreateMaterial() {
        Trainer trainer = new Trainer(new CreateMaterials());
        assertThat(trainer.doWork(), equalTo("Materials"));
    }

    @Test
    public void testTakeCourse() {
        Trainer trainer = new Trainer(new TakeCourse());
        assertThat(trainer.doWork(), equalTo("HappyStudents"));
    }

    @Test
    public void testComplexWork() {
        Trainer trainer = new Trainer(new ComplexWork(Arrays.asList(new CreateMaterials(), new TakeCourse())));
        assertThat(trainer.doWork(), equalTo("Materials, HappyStudents"));
    }

    @Test
    public void testChangeWork() {
        Trainer trainer = new Trainer(new HasNoWork());
        assertThat(trainer.doWork(), equalTo(""));
        trainer.setWork(new CreateMaterials());
        assertThat(trainer.doWork(), equalTo("Materials"));
    }

}
