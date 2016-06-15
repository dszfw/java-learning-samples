package effectivejava.item22;

public class StaticVsNonStaticInnerClasses {
    private int var;

    public StaticVsNonStaticInnerClasses() {
        var = 123;
    }

    public static void main(String[] args) {
        StaticVsNonStaticInnerClasses main = new StaticVsNonStaticInnerClasses();
        X x = main.new X();
        x.showVar();
    }

    static class C {
        public static int i = 42;
        public void showVar() {
            // cannot be referenced from static context
//            System.out.println(var);
        }
    }

    class X {
//        public static int i = 42;
        void showVar() {
            System.out.println(StaticVsNonStaticInnerClasses.this.var);
        }
    }
}