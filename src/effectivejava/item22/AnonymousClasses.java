package effectivejava.item22;

import java.util.Comparator;

public class AnonymousClasses {

    private static final String CONSTANT = "123";

    // static context
    {
        Object someObject = new Object() {

//            public static int i = 42;

            @Override
            public String toString() {
                return "nothing" + CONSTANT;
            }
        };
        System.out.println(someObject);
    }

    private final int cc = 1;
    // fields can be non final
    private AnonymousClasses self;

    private final Comparator<String> stringComparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            System.out.println(cc);
            System.out.println(self);
            self = null;
            return 0;
        }
    };

    public AnonymousClasses() {
        this.self = this;
    }

    public static void main(String[] args) {
        AnonymousClasses main = new AnonymousClasses();
        // can't use instanceof
        System.out.println(main.stringComparator.getClass());

        // lexical scope, should be final (may be implicitly for Java 8)
        String some = "some";
        Object o = new Object() {
            @Override
            public String toString() {
                // can't do this, should be final
//                some = "qwer";
                return some;
            }
        };
        o.toString();
    }
}