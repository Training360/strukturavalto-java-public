package localvariables;

public class LocalVariablesMain {

    public static void main(String[] args) {
        boolean b = false;

        System.out.println(b);

        int a = 2;

        int i = 4, j = 5;

        int k = i;

        String s = "Hello World!";

        String t = s;

        {
            int x = 0;

            System.out.println(a);
        }
        // System.out.println(x); // Nem látható
    }

}
