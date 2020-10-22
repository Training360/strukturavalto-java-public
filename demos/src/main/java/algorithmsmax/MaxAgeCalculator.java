package algorithmsmax;

import java.util.List;

public class MaxAgeCalculator {

    public Trainer trainerWithMaxAge(List<Trainer> trainers) {
        Trainer trainerWithMaxAge = null;
        for (Trainer trainer: trainers) {
            if (trainerWithMaxAge == null || (trainer.getAge() > trainerWithMaxAge.getAge())) {
                trainerWithMaxAge = trainer;
            }
        }
        return trainerWithMaxAge;
    }
}
