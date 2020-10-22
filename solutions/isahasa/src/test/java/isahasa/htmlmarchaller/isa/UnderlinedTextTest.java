package isahasa.htmlmarchaller.isa;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UnderlinedTextTest {
	@Test
	public void getBytes() throws Exception {
		UnderlinedHtmlText underlinedHtmlText = new UnderlinedHtmlText("asd");

		assertThat(underlinedHtmlText.getPlainText() , is("<u>asd</u>"));
	}

}