package hu.nive.ujratervezes.forest;

public class WhitebarkPine extends Tree {

    public WhitebarkPine() {
    }

    public WhitebarkPine(int height) {
        super(height);
    }

    @Override
    public void irrigate() {
        height += 2;
    }

    @Override
    public String getStatus() {
        return String.format("There is a %d tall WhitebarkPine in the forest.", height);
    }
}
