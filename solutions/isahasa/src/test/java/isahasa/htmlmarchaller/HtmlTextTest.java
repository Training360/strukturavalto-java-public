package isahasa.htmlmarchaller;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HtmlTextTest {
    @Test
    public void getBytes() {
        HtmlText htmlText = new HtmlText("aasd");

        assertEquals("aasd", htmlText.getPlainText());
    }

}