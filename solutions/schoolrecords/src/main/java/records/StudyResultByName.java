package records;

public class StudyResultByName {

    private double studyAverage;
    private String studentName;

    public StudyResultByName(double studyAverage, String studentName) {
        this.studyAverage = studyAverage;
        this.studentName = studentName;
    }

    public double getStudyAverage() {
        return studyAverage;
    }

    public String getStudentName() {
        return studentName;
    }
}
