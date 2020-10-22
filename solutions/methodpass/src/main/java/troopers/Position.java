package troopers;

public class Position {

    private double posX;
    private double posY;

    public Position(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double distanceFrom(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Cannot calculate distance from unknown position");
        }
        return Math.sqrt(Math.pow(this.posX - position.posX, 2) + Math.pow(this.posY - position.posY, 2));
    }
}
