package isahasa;

public class Trainer {

    private Work work;

    public Trainer(Work work) {
        this.work = work;
    }

    public String doWork() {
        return work.complete();
    }

    public void setWork(Work work) {
        this.work = work;
    }
}
