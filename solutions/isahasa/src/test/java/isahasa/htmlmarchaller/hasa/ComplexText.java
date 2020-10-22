package isahasa.htmlmarchaller.hasa;

import isahasa.htmlmarchaller.TextSource;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ComplexText {
	@Test
	public void UnderlinedBold() {
		TextSourceImplementation textSourceImplementation = new TextSourceImplementation("qwe");
		TextSource underlined = new Underlined(new Bold(textSourceImplementation));

		assertThat(underlined.getPlainText(), is("<u><b>qwe</b></u>"));
	}

	@Test
	public void BoldUnderlined() {
		TextSourceImplementation textSourceImplementation = new TextSourceImplementation("qwe");
		TextSource underlined = new Bold(new Underlined(textSourceImplementation));

		assertThat(underlined.getPlainText(), is("<b><u>qwe</u></b>"));
	}

	@Test
	public void ItalicUnderlined() {
		TextSourceImplementation textSourceImplementation = new TextSourceImplementation("qwe");
		TextSource underlined = new Italic(new Underlined(textSourceImplementation));

		assertThat(underlined.getPlainText(), is("<i><u>qwe</u></i>"));
	}

	@Test
	public void ItalicBoldUnderlined() {
		TextSourceImplementation textSourceImplementation = new TextSourceImplementation("qwe");
		TextSource underlined = new Italic(new Bold(new Underlined(textSourceImplementation)));

		assertThat(underlined.getPlainText(), is("<i><b><u>qwe</u></b></i>"));
	}

}