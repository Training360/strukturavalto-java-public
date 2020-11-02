package clone.issuetracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CommentTest {

    @Test
    public void testCreateComment() {
        LocalDateTime time = LocalDateTime.of(2017, 4, 26, 8, 0, 0);
        Comment comment = new Comment("Comment1", time);

        assertEquals("Comment1", comment.getText());
        assertEquals(time, comment.getTime());
    }

    @Test
    public void testCreateCommentBasedOnAnotherComment() {
        LocalDateTime time = LocalDateTime.of(2017, 4, 26, 8, 0, 0);
        Comment comment = new Comment("Comment1", time);
        Comment copied = new Comment(comment);

        assertEquals("Comment1", copied.getText());
        assertEquals(time, copied.getTime());
    }

}