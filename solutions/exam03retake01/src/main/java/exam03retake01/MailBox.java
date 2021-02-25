package exam03retake01;

import java.util.ArrayList;
import java.util.List;

public class MailBox {

    private List<Mail> mails = new ArrayList<>();


    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> getMails() {
        return mails;
//        return new ArrayList<>(mails);
    }


    public List<Mail> findByCriteria(String criteria) {
        if (criteria.startsWith("to:")) {
            return findByTo(criteria.substring(3));
        }
        else if (criteria.startsWith("from:")) {
            return findByFrom(criteria.substring(5));
        }
        else {
            return findByContent(criteria);
        }
    }

    private List<Mail> findByContent(String criteria) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail: mails) {
            if (mail.match(criteria)) {
                result.add(mail);
            }
        }
        return result;
    }

    private List<Mail> findByTo(String substring) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail: mails) {
            for (Contact contact: mail.getTo()) {
                if (contact.match(substring)) {
                    result.add(mail);
                }
            }
        }
        return result;
    }

    private List<Mail> findByFrom(String substring) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail: mails) {
            if (mail.getFrom().match(substring)) {
                result.add(mail);
            }
        }
        return result;
    }
}
