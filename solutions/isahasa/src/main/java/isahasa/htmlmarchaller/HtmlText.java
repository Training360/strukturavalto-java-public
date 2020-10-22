package isahasa.htmlmarchaller;

public class HtmlText implements TextSource {
	private final String plainText;

	public HtmlText(String plainText) {
		this.plainText = plainText;
	}

	@Override
	public String getPlainText() {
		return plainText;
	}
}
