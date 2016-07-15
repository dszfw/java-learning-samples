package naftalinwadler.generics.chapter6;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * The Principle of Truth in Advertising:
 * the reified type of an array must be a subtype
 * of the erasure of its static type.
 */
public class TruthInAdvertisingPrinciple {
    // T[] will be erasure to Object[]
    public static <T> T[] badToArray(Collection<T> c) {
        // erasure of static type = Object[]
        // reified type of the array = Object[]
        // Object[] is subtype of Object[]
        // => principle is ok
        T[] a = (T[]) new Object[c.size()]; // unchecked cast
        int i = 0;
        for (T x : c) a[i++] = x;
        return a;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one", "two");
        // erasure of static type = String[]
        // reified type of the array = Object[]
        // Object[] is not a subtype of String[]
        // => principle is violated
        String[] a = badToArray(strings); // class cast error
    }
}
