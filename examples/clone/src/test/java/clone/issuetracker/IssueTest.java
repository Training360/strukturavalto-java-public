package clone.issuetracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class IssueTest {

    private LocalDateTime time = LocalDateTime.of(2017, 4, 26, 8, 0, 0);

    private Issue issue = new Issue("Issue 1", time, Status.IN_PROGRESS);

    @BeforeEach
    public void addComments() {
        issue.getComments().add(new Comment("Comment 1", LocalDateTime.now()));
        issue.getComments().add(new Comment("Comment 2", LocalDateTime.now()));
    }

    @Test
    public void testCreateIssue() {
        assertEquals("Issue 1", issue.getName());
        assertEquals(time, issue.getTime());
        assertEquals(Status.IN_PROGRESS, issue.getStatus());
    }

    @Test
    public void testCopyIssue() {
        Issue copied = new Issue(issue, CopyMode.WITHOUT_COMMENTS);

        assertEquals("Issue 1", copied.getName());
        assertEquals(time, copied.getTime());
        assertEquals(Status.IN_PROGRESS, copied.getStatus());
        assertTrue(copied.getComments().isEmpty());
    }

    @Test
    public void testDeepCopyIssue() {
        Issue copied = new Issue(issue, CopyMode.WITH_COMMENTS);

        assertEquals("Issue 1", copied.getName());
        assertEquals(time, copied.getTime());
        assertEquals(Status.IN_PROGRESS, copied.getStatus());
        assertEquals(2,copied.getComments().size());

        copied.getComments().get(0).setText("Comment 1 modified");
        assertEquals("Comment 1",issue.getComments().get(0).getText());
        assertEquals("Comment 1 modified",copied.getComments().get(0).getText());
    }

}