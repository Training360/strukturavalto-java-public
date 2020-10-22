package job;

public class Job implements Comparable<Job> {

    private final int priority;
    private final String jobDescription;
    private final boolean urgent;

    public Job(int priority, String jobDescription) {
        this.priority = priority;
        this.jobDescription = jobDescription;
        urgent = priority < 5;
    }

    public int getPriority() {
        return priority;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public boolean isUrgent() { return urgent; }

    @Override
    public int compareTo(Job o) {
        return this.priority - o.priority;
    }
}

