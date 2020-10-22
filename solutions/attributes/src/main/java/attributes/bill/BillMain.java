package attributes.bill;

public class BillMain {

    public static void main(String[] args) {
        Bill bill = new Bill();
        bill.addItem(new Item("Bread", 3, 360));
        bill.addItem(new Item("Milk", 2, 220));
        bill.addItem(new Item("Water", 4, 100));

        System.out.println(bill.calculateTotalPrice());
    }
}
