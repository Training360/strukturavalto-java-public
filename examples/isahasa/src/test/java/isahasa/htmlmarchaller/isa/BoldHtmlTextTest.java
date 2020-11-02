package isahasa.htmlmarchaller.isa;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoldHtmlTextTest {
    @Test
    public void getBytes() throws Exception {
        BoldHtmlText boldHtmlText = new BoldHtmlText("asd");

        assertEquals("<b>asd</b>", boldHtmlText.getPlainText());
    }

}