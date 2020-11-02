package collectionspriorityqueue;

import org.junit.jupiter.api.Test;

import job.Job;
import job.NoJobException;


import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class JobDispatcherTest {


    @Test
    public void emptyQueueShouldThrowException() throws NoJobException {
        Exception ex = assertThrows(NoJobException.class, () -> {
            new JobDispatcher().dispatchNextJob(new PriorityQueue<>());
        });
        assertEquals("No job available, get a rest!", ex.getMessage());
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
        assertEquals("mostImportant", nextJob.getJobDescription());
        assertEquals(1, nextJob.getPriority());
    }
}
