package primitivetypes;

public class PrimitiveTypesMain {
    public static void main(String[] args) {
        System.out.println(new PrimitiveTypes().toBinaryString(100));
        System.out.println(Integer.toBinaryString(100));

        System.out.println(new PrimitiveTypes().toBinaryString(-100));
        System.out.println(Integer.toBinaryString(-100));

        System.out.println(new PrimitiveTypes().toBinaryString(-3485));
        System.out.println(Integer.toBinaryString(-3485));

        System.out.println(new PrimitiveTypes().toBinaryString(-10));
        System.out.println(Integer.toBinaryString(-10));
        int i = 0b11111111111111111111111111110110;
        System.out.println(i);
    }
}
