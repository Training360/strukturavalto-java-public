package controlselection.accents;

public class WithoutAccents {

    public static final String LETTERS_WITH_ACCENTS = "áéíóöőúüűÁÉÍÓÖŐÚÜŰ";

    public static final String LETTERS_WITHOUT_ACCENTS = "aeiooouuuAEIOOOUUU";

    public char convertToCharWithoutAccents(char c) {
        int index = LETTERS_WITH_ACCENTS.indexOf(c);
        if (index >= 0) {
            return LETTERS_WITHOUT_ACCENTS.charAt(index);
        }
        else {
            return c;
        }
    }
}
