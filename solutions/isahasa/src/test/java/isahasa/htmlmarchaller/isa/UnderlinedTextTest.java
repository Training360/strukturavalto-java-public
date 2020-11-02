package isahasa.htmlmarchaller.isa;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UnderlinedTextTest {
    @Test
    public void getBytes() throws Exception {
        UnderlinedHtmlText underlinedHtmlText = new UnderlinedHtmlText("asd");

        assertEquals("<u>asd</u>", underlinedHtmlText.getPlainText());
    }

}