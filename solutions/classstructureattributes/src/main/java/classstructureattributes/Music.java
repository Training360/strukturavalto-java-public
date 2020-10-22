package classstructureattributes;

import java.util.Scanner;

public class Music {

    public static void main(String[] args) {
        Song song = new Song();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ki a kedvenc dalod előadója?");
        song.band = scanner.nextLine();
        System.out.println("Mi a dal címe?");
        song.title = scanner.nextLine();
        System.out.println("Hány perc a hossza?");
        song.length = scanner.nextInt();

        System.out.println(song.band + " - " + song.title + " (" + song.length + "perc)");
    }
}
