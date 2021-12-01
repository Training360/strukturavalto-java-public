package hu.nive.ujratervezes.lettermultiplier;

public class LetterMultiplier {

    public String multiply(String input, int number) {

        if (input == null || input.isEmpty() || input.isBlank() || number < 0) {
            throw new IllegalArgumentException();
        }

        StringBuilder multiplied = new StringBuilder();

        for (char c : input.toCharArray()) {
            for (int i = 0; i < number; i++) {
                multiplied.append(c);
            }
        }

        return multiplied.toString();
    }

}
