package naftalinwadler.generics.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
The Get and Put Principle: use an extends wildcard when you only get values out of a
structure, use a super wildcard when you only put values into a structure, and don’t use
a wildcard when you both get and put.
 */
public class BoundedWildcards {
    static void extendsUsage() {
        List<? extends Number> numbers = Arrays.<Double>asList(3.14, 2.718);

        // subtyping
        numbers = new ArrayList<Double>();

        // can't compile
//        numbers.add(42);
        // only null is allowed
        numbers.add(null);
        // In general, if a structure contains elements with a
        // type of the form ? extends E , we can get elements
        // out of the structure, but we cannot put elements into the structure.
        Number number = numbers.get(0);
    }

    static void superUsage() {
        List<? super Number> list = Arrays.asList(42, 2.718);

        // supertyping
        list = new ArrayList<Object>();

        // Double
        list.add(3.14);
        // Integer
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
        list.add(null);
        // can't compile
//        list.add(new Object());

        Object obj = list.get(0);
    }
}
