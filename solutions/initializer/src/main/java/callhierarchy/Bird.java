package callhierarchy;

public class Bird {
   static {
        System.out.println("Bird class static initializer block, class loaded");
    }

    public Bird() {
        System.out.println("Bird class constructor");
    }

    {
        System.out.println("Bird class initializer block");
    }
}
