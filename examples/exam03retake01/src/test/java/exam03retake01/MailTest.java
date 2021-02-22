package exam03retake01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MailTest {

    @Test
    void create() {
        Mail mail = new Mail(new Contact("John Doe", "johndoe@example.com"),
                List.of(new Contact("Jane Doe", "janedoe@example.com"), new Contact("John Doe", "jackdoe@example.com")),
                        "Doe Family",
                "Hi All!");

        assertEquals("John Doe", mail.getFrom().getName());
        assertEquals("Jane Doe", mail.getTo().get(0).getName());
        assertEquals("jackdoe@example.com", mail.getTo().get(1).getEmail());
        assertEquals("Doe Family", mail.getSubject());
        assertEquals("Hi All!", mail.getMessage());
    }
}
