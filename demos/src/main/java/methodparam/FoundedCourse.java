package methodparam;

public class FoundedCourse {

    private Course course;

    private int position;

    public FoundedCourse(Course course, int position) {
        this.course = course;
        this.position = position;
    }

    public Course getCourse() {
        return course;
    }

    public int getPosition() {
        return position;
    }
}
