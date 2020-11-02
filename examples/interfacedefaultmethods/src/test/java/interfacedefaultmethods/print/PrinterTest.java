package interfacedefaultmethods.print;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrinterTest {

    @Test
    public void printNewsPaper() {
        NewsPaper newspaper = new NewsPaper();
        newspaper.addPage("Page1");
        assertEquals("Page1\n", new Printer().print(newspaper));
    }

    @Test
    public void printStoryBook() {
        StoryBook storyBook = new StoryBook();
        storyBook.addPage("Page1", Printable.BLACK);
        storyBook.addPage("Page2", "#ff0000");

        assertEquals("Page1\n[#ff0000]Page2\n", new Printer().print(storyBook));
    }
}
