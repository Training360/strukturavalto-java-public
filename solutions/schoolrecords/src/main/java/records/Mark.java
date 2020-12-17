package records;

public class Mark {

    private MarkType markType;
    private Subject subject;
    private Tutor tutor;

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        if (markType == null) {
            throw new NullPointerException("Mark type must not be null!");
        }
        this.markType = markType;

        if (subject == null || tutor == null) {
            throw new NullPointerException("Both subject and tutor must be provided!");
        }

        this.subject = subject;
        this.tutor = tutor;
    }

    public MarkType getMarkType() {
        return markType;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public String toString() {
        return markType.getDescription() + "(" + markType.getValue() + ")";
    }
}
