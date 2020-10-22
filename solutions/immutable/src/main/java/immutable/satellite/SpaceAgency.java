package immutable.satellite;

import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {

    private List<Satellite> tracedSatellites = new ArrayList<>();

    public void registerSatellite(Satellite satellite){
        if (satellite == null){
            throw new NullPointerException("Parameter must not be null!");
        }
        tracedSatellites.add(satellite);
    }

    public Satellite findSatelliteByRegisterIdent(String registerIdent) {
        for (Satellite s : tracedSatellites){
            if (s.getRegisterIdent().equals(registerIdent)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Satellite with the given registration cannot be found!" + registerIdent);
    }

    public String toString(){
        return tracedSatellites.toString();
    }
}
