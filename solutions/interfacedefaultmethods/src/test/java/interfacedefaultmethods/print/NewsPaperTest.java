package interfacedefaultmethods.print;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewsPaperTest {

    @Test
    public void testCreateAndAddPage() {
        NewsPaper newspaper = new NewsPaper();

        assertEquals(0, newspaper.getLength());

        newspaper.addPage("Page1");
        assertEquals(1, newspaper.getLength());
        assertEquals("Page1", newspaper.getPage(0));
        assertEquals(Printable.BLACK, newspaper.getColor(0));
    }
}
