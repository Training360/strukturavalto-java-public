package introexception;

public class TrainerCreator {

    private Trainer trainer;

    public boolean createTrainer(String name, String age) {
        if (!new TrainerAgeValidator().isValidAge(age)) {
            return false;
        }
        else {
            trainer = new Trainer(name, new TrainerAgeValidator().parseAge(age));
            return true;
        }
    }

    public Trainer getTrainer() {
        if (trainer == null) {
            throw new IllegalStateException("Could not create trainer");
        }
        return trainer;
    }
}
