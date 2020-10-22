package talentshow;

public class Vote {

    private long id;

    private int number;

    public Vote(long id, int num) {
        this.id = id;
        this.number = num;
    }

    public long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void incNum() {
        this.number += 1;
    }
}
