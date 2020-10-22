package introinheritance.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String barcode) {

        Item toBeRemoved = null;
        for (Item currentItem : items) {
            if (currentItem.getBarcode().equals(barcode)) {
                toBeRemoved = currentItem;
            }
        }
        items.remove(toBeRemoved);
    }

    public void clearBasket() {
        items.clear();
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
