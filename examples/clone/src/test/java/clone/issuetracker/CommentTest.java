package clone.issuetracker;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class CommentTest {

    @Test
    public void testCreateComment(){
        LocalDateTime time = LocalDateTime.of(2017,4,26,8,0,0);
        Comment comment=new Comment("Comment1", time);

        assertThat(comment.getText(), equalTo("Comment1"));
        assertThat(comment.getTime(), equalTo(time));
    }

    @Test
    public void testCreateCommentBasedOnAnotherComment(){
        LocalDateTime time = LocalDateTime.of(2017,4,26,8,0,0);
        Comment comment = new Comment("Comment1", time);
        Comment copied = new Comment(comment);

        assertThat(copied.getText(), equalTo("Comment1"));
        assertThat(copied.getTime(), equalTo(time));
    }

}