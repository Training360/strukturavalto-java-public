package finalmodifier;

import java.util.Arrays;
import java.util.List;

public class Week {

    public static final List<String> DAYS = Arrays.asList("Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap");

    public static void main(String[] args) {
        DAYS.set(2, "Szerda");
        System.out.println(DAYS);
    }
}
