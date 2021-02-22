package exam03retake01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MailBoxTest {

    MailBox mailBox = new MailBox();

    @BeforeEach
    void init() {
        Mail mail1 = new Mail(new Contact("John Doe", "johndoe@example.com"),
                List.of(new Contact("Jane Doe", "janedoe@example.com"), new Contact("Jack Doe", "jackdoe@example.com")),
                "Doe Family",
                "Hi All!");

        Mail mail2 = new Mail(new Contact("John Doe", "johndoe@example.com"),
                List.of(new Contact("John Smith", "johnsmith@example.com")),
                "Johnes",
                "Hi!");

        Mail mail3 = new Mail(new Contact("John Doe", "johndoe@example.com"),
                List.of(new Contact("Jane Smith", "janesmith@example.com")),
                "John - Jane",
                "Hello!");

        Mail mail4 = new Mail(new Contact("Jane Doe", "janedoe@example.com"),
                List.of(new Contact("John Doe", "johndoe@example.com"), new Contact("Jack Doe", "jackdoe@example.com")),
                "RE: Doe Family",
                "Rerere!");

        mailBox.addMail(mail1);
        mailBox.addMail(mail2);
        mailBox.addMail(mail3);
        mailBox.addMail(mail4);
    }

    @Test
    void addMail() {
        List<Mail> mails = mailBox.getMails();
                assertEquals(4, mails.size());
        assertEquals("Rerere!", mails.get(3).getMessage());
    }

    @Test
    void findFrom() {
        List<Mail> mails =  mailBox.findByCriteria("from:johndoe@example.com");
        assertEquals(3, mails.size());
    }

    @Test
    void findTo() {
        List<Mail> mails =  mailBox.findByCriteria("to:Jack Doe");
        assertEquals(2, mails.size());

    }

    @Test
    void findSubject() {
        List<Mail> mails =  mailBox.findByCriteria("Hi");
        assertEquals(2, mails.size());

    }

    @Test
    void findMessage() {
        List<Mail> mails =  mailBox.findByCriteria("Rerere");
        assertEquals(1, mails.size());

    }
}
