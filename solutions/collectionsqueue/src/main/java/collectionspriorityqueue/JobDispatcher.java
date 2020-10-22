package collectionspriorityqueue;

import job.Job;
import job.NoJobException;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {

    public Queue<Job> addJob(Job... jobs) {
        return new PriorityQueue<>(Arrays.asList(jobs));
    }

    public Job dispatchNextJob(Queue<Job> jobs) throws NoJobException {

        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.poll();
    }
}
