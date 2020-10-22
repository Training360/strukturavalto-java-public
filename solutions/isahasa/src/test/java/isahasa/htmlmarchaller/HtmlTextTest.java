package isahasa.htmlmarchaller;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HtmlTextTest {
	@Test
	public void getBytes() {
		HtmlText htmlText = new HtmlText("aasd");

		assertThat(htmlText.getPlainText(),
				is("aasd"));
	}

}