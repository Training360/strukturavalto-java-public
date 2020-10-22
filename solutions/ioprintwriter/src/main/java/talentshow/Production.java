package talentshow;

public class Production {

    private long id;

    private String Name;

    public Production(long id, String name) {
        this.id = id;
        Name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }
}
