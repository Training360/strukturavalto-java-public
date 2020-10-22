package isahasa.htmlmarchaller.isa;

import isahasa.htmlmarchaller.HtmlText;

public class ItalicHtmlText extends HtmlText {
	public ItalicHtmlText(String plainText) {
		super(plainText);
	}

	@Override
	public String getPlainText() {
		return "<i>" + super.getPlainText() + "</i>";
	}
}
