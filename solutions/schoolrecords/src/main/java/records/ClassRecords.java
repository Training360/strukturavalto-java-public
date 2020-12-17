package records;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private List<Student> students = new ArrayList<>();
    private String className;
    private Random rnd;

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public boolean addStudent(Student student) {
        if (getStudentByNameOrNull(student.getName()) != null) {
            return false;
        }
        return students.add(student);
    }

    public boolean removeStudent(Student student) {
        Student foundStudent = getStudentByNameOrNull(student.getName());
        if (foundStudent != null) {
            students.remove(foundStudent);
            return true;
        } else {
            return false;
        }
    }

    public double calculateClassAverage() {
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double classAverage = 0;
        int countStudent = 0;
        for (Student student : students){
            double studentAverage = student.calculateAverage();
            if (studentAverage != 0){
                classAverage += studentAverage;
                countStudent++;
            }
        }
        if (countStudent == 0){
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        return Math.round(100 * classAverage / countStudent ) / 100.0;
    }

    public double calculateClassAverageBySubject(Subject subject) {

        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double classAverage = 0;
        int countStudent = 0;
        for (Student student : students){
            double studentAverage = student.calculateSubjectAverage(subject);
            if (studentAverage != 0){
                classAverage += studentAverage;
                countStudent++;
            }
        }
        if (countStudent == 0){
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        return Math.round(100 * classAverage / countStudent ) / 100.0;
    }

    public Student findStudentByName(String name) {
        if (students.isEmpty()){
            throw new IllegalStateException("No students to search!");
        }
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        Student student = getStudentByNameOrNull(name);
        if (student == null) {
            throw new IllegalArgumentException("Student by this name cannot be found! " + name);
        }
        return student;
    }

    private Student getStudentByNameOrNull(String name) {
        for (Student student : students){
            if (student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }

    public Student repetition(){
        if (students.isEmpty()){
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(this.rnd.nextInt(students.size()));
    }

    public List<StudyResultByName> listStudyResults(){

        List<StudyResultByName> tempList = new ArrayList<>();
        for (Student student : students){
            tempList.add(new StudyResultByName(student.calculateAverage(), student.getName()));
        }
        return tempList;
    }

    public String listStudentNames(){
        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            sb.append(s.getName()).append(", ");
        }
        return sb.toString().substring(0, sb.toString().lastIndexOf(","));
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    public String getClassName() {
        return className;
    }
}
