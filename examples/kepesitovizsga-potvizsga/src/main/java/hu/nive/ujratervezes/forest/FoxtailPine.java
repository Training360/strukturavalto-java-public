package hu.nive.ujratervezes.forest;

public class FoxtailPine extends Tree {

    public FoxtailPine() {
    }

    public FoxtailPine(int height) {
        super(height);
    }

    @Override
    public void irrigate() {
        height += 1;
    }

    @Override
    public String getStatus() {
        return String.format("There is a %d tall FoxtailPine in the forest.", height);
    }
}
