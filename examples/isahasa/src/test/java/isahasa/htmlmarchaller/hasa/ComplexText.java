package isahasa.htmlmarchaller.hasa;

import isahasa.htmlmarchaller.TextSource;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ComplexText {
    @Test
    public void UnderlinedBold() {
        TextSourceImplementation textSourceImplementation = new TextSourceImplementation("qwe");
        TextSource underlined = new Underlined(new Bold(textSourceImplementation));

        assertEquals("<u><b>qwe</b></u>", underlined.getPlainText());
    }

    @Test
    public void BoldUnderlined() {
        TextSourceImplementation textSourceImplementation = new TextSourceImplementation("qwe");
        TextSource underlined = new Bold(new Underlined(textSourceImplementation));

        assertEquals("<b><u>qwe</u></b>", underlined.getPlainText());
    }

    @Test
    public void ItalicUnderlined() {
        TextSourceImplementation textSourceImplementation = new TextSourceImplementation("qwe");
        TextSource underlined = new Italic(new Underlined(textSourceImplementation));

        assertEquals("<i><u>qwe</u></i>", underlined.getPlainText());
    }

    @Test
    public void ItalicBoldUnderlined() {
        TextSourceImplementation textSourceImplementation = new TextSourceImplementation("qwe");
        TextSource underlined = new Italic(new Bold(new Underlined(textSourceImplementation)));

        assertEquals("<i><b><u>qwe</u></b></i>", underlined.getPlainText());
    }

}