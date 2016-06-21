package naftalinwadler.generics.chapter2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoundedWildcards {
    static void extendsUsage() {
        List<? extends Number> numbers = Arrays.<Double>asList(3.14, 2.718);
        // can't compile
//        numbers.add(42);
        // In general, if a structure contains elements with a
        // type of the form ? extends E , we can get elements
        // out of the structure, but we cannot put elements into the structure.

        // subtyping
        numbers = new ArrayList<Double>();
    }

    static void superUsage() {
        List<? super Number> list = Arrays.asList(42, 2.718);
        list.add(3.14);
        list.add(7);
        list.add(new Number() {
            @Override
            public int intValue() {
                return 0;
            }

            @Override
            public long longValue() {
                return 0;
            }

            @Override
            public float floatValue() {
                return 0;
            }

            @Override
            public double doubleValue() {
                return 0;
            }
        });

        // can't compile
//        list.add(new Object());

        // supertyping
        list = new ArrayList<Serializable>();
    }
}
