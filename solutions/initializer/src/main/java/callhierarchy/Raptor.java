package callhierarchy;


public class Raptor extends Bird {
    static {
        System.out.println("Raptor class static initializer block, class loaded");
    }

    public Raptor(){
        System.out.println("Raptor class constructor");
    }

    {
        System.out.println("Raptor class initializer block");
    }
}
