package interfacedefaultmethods.print;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrinterTest {

    @Test
    public void printNewsPaper() {
        NewsPaper newspaper = new NewsPaper();
        newspaper.addPage("Page1");
        assertThat(new Printer().print(newspaper), equalTo("Page1\n"));
    }

    @Test
    public void printStoryBook() {
        StoryBook storyBook = new StoryBook();
        storyBook.addPage("Page1", Printable.BLACK);
        storyBook.addPage("Page2", "#ff0000");

        assertThat(new Printer().print(storyBook), equalTo("Page1\n[#ff0000]Page2\n"));
    }
}
