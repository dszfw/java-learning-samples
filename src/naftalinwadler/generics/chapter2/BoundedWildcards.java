package naftalinwadler.generics.chapter2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
The Get and Put Principle: use an extends wildcard when you only get values out of a
structure, use a super wildcard when you only put values into a structure, and don’t use
a wildcard when you both get and put.

You might think List<? extends Parent> is "a list of things that extends Parent", but that's not actually what it means. It means "there exists some type C, such that C extends Parent, and this is a List of that C." Since we don't know what that C is, we don't know that a Parent is-a C, so you can't put a Parent in a List<C>. (C here is called a capture type.) But, you can take one out, because you get C out of the List, and C is-a Parent, so that's good.

 **/
public class BoundedWildcards {
    static void extendsUsage() {
        List<? extends Number> numbers = Arrays.<Integer>asList(3, 42);

        // subtyping
        numbers = new ArrayList<Double>();

        // won't compile
//        numbers.add(42);
        // only null is allowed
        numbers.add(null);
        // In general, if a structure contains elements with a
        // type of the form ? extends E , we can get elements
        // out of the structure, but we cannot put elements into the structure.
        Number number = numbers.get(0);
    }

    static void superUsage() {
        // Object type will be inferred
        List<? super Number> list = Arrays.asList(42, 2.718, new Object());
        // the above statement the same as below
//        List<? super Number> list = Arrays.<Object>asList(42, 2.718, new Object());
        // won't compile
//        List<? super Number> list = Arrays.<Number>asList(42, 2.718, new Object());

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
        // won't compile
//        list.add(new Object());
//        list.add(new Serializable(){});

        Object obj = list.get(0);
    }
}
