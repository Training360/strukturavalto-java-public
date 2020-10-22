package jvm;

import java.util.Random;

public class SorterMain {

    public static void main(String[] args) {
        while(true) {
            Random random = new Random();
            int size = random.nextInt(500_000);
            System.out.println("Creating and sorting list with size " + size);
            new Sorter().createListAndSort(size);
        }
    }
}
