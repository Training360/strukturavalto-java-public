package isahasa.htmlmarchaller.hasa;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BoldTest {
	@Test
	public void getPlainText() {
		TextSourceImplementation textSourceImplementation = new TextSourceImplementation("qwe");
		Bold bold = new Bold(textSourceImplementation);

		assertThat(bold.getPlainText(), is("<b>qwe</b>"));
	}

}