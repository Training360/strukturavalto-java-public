package interfacedefaultmethods.print;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StoryBookTest {

    @Test
    public void testCreateAndAddPage() {
        StoryBook storyBook = new StoryBook();

        assertThat(storyBook.getLength(), equalTo(0));

        storyBook.addPage("Page1", Printable.BLACK);
        storyBook.addPage("Page2", "#FF0000");
        assertThat(storyBook.getLength(),equalTo(2));
        assertThat(storyBook.getPage(0), equalTo("Page1"));
        assertThat(storyBook.getColor(0), equalTo(Printable.BLACK));
        assertThat(storyBook.getPage(1), equalTo("Page2"));
        assertThat(storyBook.getColor(1), equalTo("#FF0000"));
    }
}
