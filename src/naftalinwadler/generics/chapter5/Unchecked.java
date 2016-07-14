package naftalinwadler.generics.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Unchecked {
    public static void uncheckedCall() {
        List raw = new ArrayList<String>();
        Object o = raw.get(0);
        // unchecked call
        raw.add("123");
    }

    public static void uncheckedAssignment() {
        List raw = new ArrayList<String>();
        // unchecked assignment
        List<String> parametrized = raw;
    }

    public static void uncheckedCasting() {
        // unchecked cast
        List<String> stringList = (List<String>)(List<?>)
                Arrays.asList("one", "two", 3);
        System.out.println(stringList); // [one, two, 3]
//        java.util.Arrays$ArrayList at runtime
        System.out.println(stringList.getClass());
//        ClassCastException
        String s = stringList.get(2);
    }

    public static void main(String[] args) {
        uncheckedCasting();
    }
}
