package isahasa.htmlmarchaller.hasa;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BoldTest {
    @Test
    public void getPlainText() {
        TextSourceImplementation textSourceImplementation = new TextSourceImplementation("qwe");
        Bold bold = new Bold(textSourceImplementation);

        assertEquals("<b>qwe</b>", bold.getPlainText());
    }

}