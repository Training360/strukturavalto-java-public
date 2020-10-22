package stringbasic;

public class Trainer {

    enum TrainerType {FULL_TIME, PART_TIME}

    private String name;

    private TrainerType type;

    public Trainer(String name, TrainerType type) {
        this.name = name;
        this.type = type;
    }

    public int hours() {
        if (type == TrainerType.FULL_TIME) {
            return 8;
        }
        else {
            return 2;
        }
    }
}
