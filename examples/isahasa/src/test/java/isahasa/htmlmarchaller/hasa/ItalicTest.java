package isahasa.htmlmarchaller.hasa;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ItalicTest {
	@Test
	public void getPlainText() {
		TextSourceImplementation textSourceImplementation = new TextSourceImplementation("qwe");
		Italic italic = new Italic(textSourceImplementation);

		assertThat(italic.getPlainText(), is("<i>qwe</i>"));
	}

}