package clone.issuetracker;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class IssueTest {

    private LocalDateTime time = LocalDateTime.of(2017,4,26,8,0,0);

    private Issue issue = new Issue("Issue 1", time, Status.IN_PROGRESS);

    @Before
    public void addComments() {
        issue.getComments().add(new Comment("Comment 1", LocalDateTime.now()));
        issue.getComments().add(new Comment("Comment 2", LocalDateTime.now()));
    }

    @Test
    public void testCreateIssue(){
        assertThat(issue.getName(), equalTo("Issue 1"));
        assertThat(issue.getTime(), equalTo(time));
        assertThat(issue.getStatus(), equalTo(Status.IN_PROGRESS));
    }

    @Test
    public void testCopyIssue(){
        Issue copied = new Issue(issue, CopyMode.WITHOUT_COMMENTS);

        assertThat(copied.getName(), equalTo("Issue 1"));
        assertThat(copied.getTime(), equalTo(time));
        assertThat(copied.getStatus(), equalTo(Status.IN_PROGRESS));
        assertThat(copied.getComments().isEmpty(), is(true));
    }

    @Test
    public void testDeepCopyIssue(){
        Issue copied = new Issue(issue, CopyMode.WITH_COMMENTS);

        assertThat(copied.getName(), equalTo("Issue 1"));
        assertThat(copied.getTime(), equalTo(time));
        assertThat(copied.getStatus(), equalTo(Status.IN_PROGRESS));
        assertThat(copied.getComments().size(), equalTo(2));

        copied.getComments().get(0).setText("Comment 1 modified");
        assertThat(issue.getComments().get(0).getText(), equalTo("Comment 1"));
        assertThat(copied.getComments().get(0).getText(), equalTo("Comment 1 modified"));
    }

}