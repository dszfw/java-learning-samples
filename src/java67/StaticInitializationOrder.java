package java67;

public class StaticInitializationOrder {
    public static void main(String[] args) {
//        int x = Child.x;
        new Child();
//        int c = Child.COMPILE_TIME_CONSTANT;
    }
}

class Parent {
    private static int x = init();
    private static int init() {
        System.out.println("Parent static init");
        return 0;
    }

    {
        System.out.println("Parent non static init");
    }
}

class Child extends Parent {
    public static int x = init();
    public static final int COMPILE_TIME_CONSTANT = 0;
    private static int init() {
        System.out.println("Child static init");
        return 0;
    }

    {
        System.out.println("Child non static init");
    }
}