package hu.nive.ujratervezes.kepesitovizsga.adddigits;

public class AddDigits {

    public int addDigits(String input) {
        int sum = 0;

        if (input == null || input.isEmpty() || input.isBlank()) {
            return -1;
        }

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }

        return sum;
    }
}
