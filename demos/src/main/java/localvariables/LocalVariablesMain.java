package localvariables;

public class LocalVariablesMain {

    public static void main(String[] args) {
        boolean b;

        b = true;

        System.out.println(b);

        int i = 100_000_000;

        double d = 3.14;

        i = (int) d;

        String s = "Hello World";

        s = null;

        System.out.println(b);
    }
}
