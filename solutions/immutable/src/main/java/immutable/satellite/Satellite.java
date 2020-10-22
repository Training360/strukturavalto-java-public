package immutable.satellite;

public class Satellite {

    private CelestialCoordinates destinationCoordinates;
    private String registerIdent;

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent) {
        if (isEmpty(registerIdent)) {
            throw new IllegalArgumentException("Register ident must not be empty!");
        }
        this.destinationCoordinates = destinationCoordinates;
        this.registerIdent = registerIdent;
    }

    public void modifyDestination(CelestialCoordinates diff) {
        destinationCoordinates = new CelestialCoordinates(destinationCoordinates.getX() + diff.getX(),
                destinationCoordinates.getY() + diff.getY(), destinationCoordinates.getZ() + diff.getZ());
    }

    public CelestialCoordinates getCoordinates() {
        return destinationCoordinates;
    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    public String toString() {
        return registerIdent + ": " + destinationCoordinates.toString();
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}
