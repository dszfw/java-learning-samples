package naftalinwadler.generics.chapter6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericsNotReifiable {
    public static void main(String[] args) {
        List<?> unbounded = new ArrayList<>();
        List<String> list = new ArrayList<>();
        List<? super String> bounded = new ArrayList<>();

        System.out.println(unbounded.getClass());
        System.out.println(list.getClass());
        System.out.println(bounded.getClass());

        System.out.println(unbounded instanceof List<?>);
        // instance testing illegal
//        System.out.println(list instanceof List<String>);
//        System.out.println(bounded instanceof List<? super String>);
    }

    public static <T> void uncheckedCasting(Object obj) {
        if (obj instanceof List<?>) {
            // unchecked
            List<T> list = (List<T>) obj;
        }
    }

    public static <T> void checkedCasting(Collection<T> collection) {
        if (collection instanceof List<?>) {
            List<T> list = (List<T>) collection;
        }
    }
}
