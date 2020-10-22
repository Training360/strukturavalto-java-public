package collectionsdeque;

import job.Job;
import job.NoJobException;

import java.util.ArrayDeque;
import java.util.Deque;

public class JobQueue {
    public Deque<Job> addJobByUrgency(Job... jobs) {
        Deque<Job> jobQueue = new ArrayDeque<>();
        for (Job j : jobs) {
            if (j.isUrgent()) {
                jobQueue.addFirst(j);
            } else {
                jobQueue.addLast(j);
            }
        }
        return jobQueue;
    }

    public Job dispatchUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.getFirst();
    }

    public Job dispatchNotUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.getLast();
    }
}
