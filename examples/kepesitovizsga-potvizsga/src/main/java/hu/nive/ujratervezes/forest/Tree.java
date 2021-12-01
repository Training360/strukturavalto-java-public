package hu.nive.ujratervezes.forest;

public abstract class Tree {

    protected int height;

    public Tree() {
    }

    public Tree(int height) {
        this.height = height;
    }

    public abstract void irrigate();

    public int getHeight() {
        return height;
    }

    public abstract String getStatus();
}
