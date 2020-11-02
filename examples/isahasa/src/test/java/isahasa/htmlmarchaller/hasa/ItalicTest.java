package isahasa.htmlmarchaller.hasa;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ItalicTest {
    @Test
    public void getPlainText() {
        TextSourceImplementation textSourceImplementation = new TextSourceImplementation("qwe");
        Italic italic = new Italic(textSourceImplementation);

        assertEquals("<i>qwe</i>", italic.getPlainText());
    }

}