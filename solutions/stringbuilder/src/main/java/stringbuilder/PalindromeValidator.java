package stringbuilder;

public class PalindromeValidator {

    public boolean isPalindrome(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text must not be null!");
        }
        text = text.trim();

        StringBuilder sb = new StringBuilder(text);
        return text.equalsIgnoreCase(sb.reverse().toString());
    }
}
