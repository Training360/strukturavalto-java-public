package immutable.satellite;


public class CelestialCoordinates {

    final private long x;
    final private long y;
    final private long z;

    public CelestialCoordinates (long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "CelestialCoordinates: " +
                "x=" + x +
                ", y=" + y +
                ", z=" + z ;
    }
}
