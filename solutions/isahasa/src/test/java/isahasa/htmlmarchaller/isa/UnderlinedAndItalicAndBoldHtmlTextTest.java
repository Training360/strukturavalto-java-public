package isahasa.htmlmarchaller.isa;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnderlinedAndItalicAndBoldHtmlTextTest {
    @Test
    public void getBytes() throws Exception {
        UnderlinedAndItalicAndBoldHtmlText underlinedAndItalicAndBoldHtmlText = new UnderlinedAndItalicAndBoldHtmlText("asd");

        assertEquals("<u><i><b>asd</b></i></u>", underlinedAndItalicAndBoldHtmlText.getPlainText());
    }

}