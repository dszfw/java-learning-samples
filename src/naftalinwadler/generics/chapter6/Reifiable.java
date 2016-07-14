package naftalinwadler.generics.chapter6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Reifiable {
    public static void main(String[] args) {
        List<?> unbounded = new ArrayList<>();
        List<String> list = new ArrayList<>();
        List<? super String> bounded = new ArrayList<>();

        System.out.println(unbounded.getClass());
        System.out.println(list.getClass());
        System.out.println(bounded.getClass());

        System.out.println(unbounded instanceof List<?>);
        // illegal
//        System.out.println(list instanceof List<String>);
//        System.out.println(bounded instanceof List<? super String>);
    }

    // unchecked
    public static <T> void doSomeUnchecked(Object collection) {
        if (collection instanceof List<?>) {
            List<T> list = (List<T>)collection;
        }
    }

    public static <T> void doSome(Collection<T> collection) {
        if (collection instanceof List<?>) {
            List<T> list = (List<T>)collection;
        }
    }
}
