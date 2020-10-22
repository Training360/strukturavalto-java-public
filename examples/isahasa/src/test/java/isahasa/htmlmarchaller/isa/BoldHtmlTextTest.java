package isahasa.htmlmarchaller.isa;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BoldHtmlTextTest {
	@Test
	public void getBytes() throws Exception {
		BoldHtmlText boldHtmlText = new BoldHtmlText("asd");

		assertThat(boldHtmlText.getPlainText() , is("<b>asd</b>"));
	}

}