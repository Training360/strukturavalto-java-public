package statements;

public class StatementsMain {

    public static void main(String[] args) {
        int i = 5 + 6;
        System.out.println(5 + 6);

        System.out.println("Hello" + i + "World!");

        StatementsMain s = new StatementsMain();

        System.out.println(i == 8);

        System.out.println("".equals("aaa"));
        System.out.println("aaa".equals("aaa"));

        System.out.println((!(i % 2 == 0)) || true);

        i++;
        i = i + 1;
        System.out.println(i);

        System.out.println(i % 2  == 0 ? "páros" : "páratlan");
    }
}
