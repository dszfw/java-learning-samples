package exmpls.reflection;

public class InstantiateAnClassObject {
    public static void main(String[] args) throws ClassNotFoundException {
        // Not init static members of Some1 class
        System.out.println(Some1.class);
        // Init static members of Some2 class
        Class<?> aClass = Class.forName("exmpls.reflection.Some2");
        System.out.println(aClass);
    }
}

class Some1 {
    public static int x = init();

    private static int init() {
        System.out.println("init() " + Some1.class);
        return 25;
    }
}

class Some2 {
    public static int x = init();

    private static int init() {
        System.out.println("init() " + Some2.class);
        return 25;
    }
}
