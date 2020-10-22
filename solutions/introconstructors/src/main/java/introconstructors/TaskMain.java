package introconstructors;

public class TaskMain {

    public static void main(String[] args) {
        Task task = new Task("Project database", "Create database initial schema");

        System.out.println("Title: " + task.getTitle());
        System.out.println("Description: " + task.getDescription());

        task.start();
        task.setDuration(100);

        System.out.println("Started at "
            + task.getStartDateTime()
            + " and took "
            + task.getDuration()
            + " minutes to finish.");
    }
}
