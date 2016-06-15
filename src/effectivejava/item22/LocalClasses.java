package effectivejava.item22;

public class LocalClasses {
    public static void main(String[] args) {
        doSome();
    }

    private static void doSome() {
        // public, private, protected modifiers are not allowed here
        // but we can use abstract
        class L {
            public int ii = 42;
            @Override
            public String toString() {
                return getClass() + ":" + ii;
            }
        }

        System.out.println(new L());
    }
}
