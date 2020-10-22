package methodchain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrainerBuilderTest {

    @Test
    public void build() {
        Trainer trainer = new TrainerBuilder()
                .withName("John Doe")
                .withAge(30)
                .build();

        assertThat(trainer.getName(), equalTo("John Doe"));
        assertThat(trainer.getAge(), equalTo(30));
    }
}
