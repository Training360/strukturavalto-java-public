package exam03retake01;

import java.util.List;

public class Mail {

    private Contact from;

    private List<Contact> to;

    private String subject;

    private String message;

    public Mail(Contact from, List<Contact> to, String subject, String message) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    public boolean match(String content) {
        return subject.contains(content) || message.contains(content);
    }

    public Contact getFrom() {
        return from;
    }

    public List<Contact> getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "from=" + from +
                ", to=" + to +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
