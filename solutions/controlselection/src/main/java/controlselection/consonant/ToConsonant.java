package controlselection.consonant;

public class ToConsonant {

    public static final String VOWELS = "aeiou";

    public char convertToConsonant(char c) {
        if (VOWELS.indexOf(c) >= 0) {
            return (char) (c + 1);
        }
        else {
            return c;
        }
    }

}
