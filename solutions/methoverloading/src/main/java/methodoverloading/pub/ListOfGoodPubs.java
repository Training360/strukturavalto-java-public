package methodoverloading.pub;

import java.util.List;

public class ListOfGoodPubs {
    private List<Pub> goodPubs;

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if (goodPubs == null || goodPubs.isEmpty()) {
            throw new IllegalArgumentException("Pub list is empty!");
        }
        this.goodPubs = goodPubs;
    }

    public Pub findTheBest() {
        Pub best = goodPubs.get(0);
        for (int i = 1; i < goodPubs.size(); i++) {
            if (goodPubs.get(i).getOpenFrom().isEarlier(best.getOpenFrom())) {
                best = goodPubs.get(i);
            }
        }
        return best;
    }
}
