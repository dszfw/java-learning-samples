package exmpls.initialization;

public class StaticInitialization {
    public static void main(String[] args) {
//        System.out.println(ClassA.y);
        int z =ClassA.y;
    }
}

class ClassA {
    public static final int x = doX();
    public static final int y = 111;
    private static int doX() {
//        System.out.println("doX()");
        return 222;
    }
}