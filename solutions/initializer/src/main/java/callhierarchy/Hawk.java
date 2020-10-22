package callhierarchy;

public class Hawk extends Raptor {

    static {
        System.out.println("Hawk class static initializer block, class loaded");
    }

    public Hawk(){
        System.out.println("Hawk class constructor");
    }

    public static void main(String[] args) {
        System.out.println("Hawk main, Hawk constructor to be called...");
        Hawk hawk = new Hawk();
        System.out.println("After Hawk constructor called...");
    }

    {
        System.out.println("Hawk class initializer block");
    }
}
