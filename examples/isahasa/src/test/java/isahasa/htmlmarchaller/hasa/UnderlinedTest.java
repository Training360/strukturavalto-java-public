package isahasa.htmlmarchaller.hasa;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UnderlinedTest {
	@Test
	public void getPlainText() {
		TextSourceImplementation textSourceImplementation = new TextSourceImplementation("qwe");
		Underlined underlined = new Underlined(textSourceImplementation);

		assertThat(underlined.getPlainText(), is("<u>qwe</u>"));
	}

}