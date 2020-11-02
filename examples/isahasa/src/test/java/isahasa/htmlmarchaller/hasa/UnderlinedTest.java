package isahasa.htmlmarchaller.hasa;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnderlinedTest {
    @Test
    public void getPlainText() {
        TextSourceImplementation textSourceImplementation = new TextSourceImplementation("qwe");
        Underlined underlined = new Underlined(textSourceImplementation);

        assertEquals("<u>qwe</u>", underlined.getPlainText());
    }

}