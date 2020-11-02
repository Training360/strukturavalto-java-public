package isahasa.htmlmarchaller.isa;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItalicHtmlTextTest {
    @Test
    public void getBytes() throws Exception {
        ItalicHtmlText italicHtmlText = new ItalicHtmlText("asd");

        assertEquals("<i>asd</i>", italicHtmlText.getPlainText());
    }

}