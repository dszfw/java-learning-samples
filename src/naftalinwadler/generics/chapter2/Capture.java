package naftalinwadler.generics.chapter2;

import java.util.List;

public class Capture {

    static void doSome(List<?> list) {
        ds(list);
    }

    private static <T> void ds(List<T> list) {
        T t = list.get(0);
        System.out.println("do do do");
        list.set(0, t);
    }
}
