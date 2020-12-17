package records;

import java.util.ArrayList;
import java.util.List;

public class Tutor {

    private String name;
    private List<Subject> taughtSubjects = new ArrayList<>();

    public Tutor(String name, List<Subject> subjects) {
        this.name = name;
        for (Subject s : subjects) {
            taughtSubjects.add(s);
        }
    }

    public boolean tutorTeachingSubject(Subject subject) {
        for (Subject s: taughtSubjects) {
            if (s.getSubjectName().equals(subject.getSubjectName())) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
