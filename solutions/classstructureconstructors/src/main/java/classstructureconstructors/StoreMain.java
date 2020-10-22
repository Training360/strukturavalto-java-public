package classstructureconstructors;

public class StoreMain {

    public static void main(String[] args) {
        Store appleStore = new Store("apple");
        appleStore.store(10);
        System.out.println(appleStore.getProduct() + ": " + appleStore.getStock());

        Store pearStore = new Store("pear");
        pearStore.store(20);
        System.out.println(pearStore.getProduct() + ": " + pearStore.getStock());

        appleStore.dispatch(5);
        pearStore.dispatch(11);
        appleStore.store(21);
        pearStore.store(8);

        System.out.println(appleStore.getProduct() + ": " + appleStore.getStock());
        System.out.println(pearStore.getProduct() + ": " + pearStore.getStock());
    }
}
