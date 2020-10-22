package methodparam;

public class TrainerData {

    private String name;

    private int age;

    private Trainer.Answer answer;

    public TrainerData(String name, int age, Trainer.Answer answer) {
        this.name = name;
        this.age = age;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Trainer.Answer getAnswer() {
        return answer;
    }
}
