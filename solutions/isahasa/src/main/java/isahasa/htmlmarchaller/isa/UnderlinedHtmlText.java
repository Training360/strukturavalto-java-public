package isahasa.htmlmarchaller.isa;

import isahasa.htmlmarchaller.HtmlText;

public class UnderlinedHtmlText extends HtmlText {

	public UnderlinedHtmlText(String plainText) {
		super(plainText);
	}

	@Override
	public String getPlainText() {
		return "<u>" + super.getPlainText() + "</u>";
	}
}
