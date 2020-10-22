package stringmethods;

public class StringMethods {

    public static void main(String[] args) {
        String name = "John Doe";
        name = name.toUpperCase();
        System.out.println(name);

        System.out.println("John Doe".toUpperCase().substring(1, 4));

        String anotherName = null;
        System.out.println("John".equals(anotherName));

        System.out.println(String.join("-", "John", "Doe", "Jack", "Doe"));
    }
}
