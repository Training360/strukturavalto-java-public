package introexception;

public class TrainerAgeValidator {

    public boolean isValidAge(String age) {
        try {
            int value = Integer.parseInt(age);
            return value >= Trainer.MIN_AGE;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public int parseAge(String age) {
        return Integer.parseInt(age);
    }
}
