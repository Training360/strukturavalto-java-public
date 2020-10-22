package interfacedefaultmethods.print;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NewsPaperTest {

    @Test
    public void testCreateAndAddPage() {
        NewsPaper newspaper = new NewsPaper();

        assertThat(newspaper.getLength(), equalTo(0));

        newspaper.addPage("Page1");
        assertThat(newspaper.getLength(),equalTo(1));
        assertThat(newspaper.getPage(0), equalTo("Page1"));
        assertThat(newspaper.getColor(0), equalTo(Printable.BLACK));
    }
}
