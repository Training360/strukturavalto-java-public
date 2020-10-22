package typeconversion.whichtype;

public class WhichTypeMain {

    public static void main(String[] args) {
        WhichType whichType = new WhichType();
        System.out.println(whichType.whichType(Long.toString(Long.MAX_VALUE - 2)));
        System.out.println(whichType.whichType(Long.toString((long)Integer.MAX_VALUE - 2)));
        System.out.println(whichType.whichType(Long.toString((long)Short.MAX_VALUE - 2)));
        System.out.println(whichType.whichType(Long.toString((long)Byte.MAX_VALUE - 2)));
        System.out.println(whichType.whichType(Long.toString(0)));
    }
}
