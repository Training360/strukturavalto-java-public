package isahasa.htmlmarchaller.isa;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ItalicAndBoldHtmlTextTest {
	@Test
	public void getBytes() throws Exception {
		ItalicAndBoldHtmlText italicAndBoldHtmlText = new ItalicAndBoldHtmlText("asd");

		assertThat(italicAndBoldHtmlText.getPlainText() , is("<i><b>asd</b></i>"));
	}

}