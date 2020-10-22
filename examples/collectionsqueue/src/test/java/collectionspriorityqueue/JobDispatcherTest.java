package collectionspriorityqueue;

import job.Job;
import job.NoJobException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.PriorityQueue;
import java.util.Queue;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class JobDispatcherTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void emptyQueueShouldThrowException() throws NoJobException {
        //Given
        exception.expect(NoJobException.class);
        exception.expectMessage("No job available");

        //When
        new JobDispatcher().dispatchNextJob(new PriorityQueue<>());
    }

    @Test
    public void highestPriorityShouldComeFirst() throws NoJobException {
        //Given
        Job mostImportant = new Job(1, "mostImportant");
        Job leastImportant = new Job(10, "leastImportant");
        Job mediumImportant = new Job(5, "mediumImportant");

        JobDispatcher dispatcher = new JobDispatcher();

        //When
        Queue<Job> availableJobs = dispatcher.addJob(mediumImportant, leastImportant, mostImportant);
        Job nextJob = dispatcher.dispatchNextJob(availableJobs);

        // Then
        assertThat(nextJob.getJobDescription(), equalTo("mostImportant"));
        assertThat(nextJob.getPriority(), equalTo(1));
    }
}
