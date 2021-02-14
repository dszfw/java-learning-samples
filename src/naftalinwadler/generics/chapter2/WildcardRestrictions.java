package naftalinwadler.generics.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardRestrictions {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        // "Unexpected wildcard" compile error
//        WildcardRestrictions.<? extends Number>genericMethodCallWithExplicitParameter();
        List<?> objs = WildcardRestrictions.<Integer>genericMethodCallWithExplicitParameter();

        // can't compile
//        WildcardRestrictions.<?>genericMethodCallWithExplicitParameter();
        WildcardRestrictions.<List<? extends Number>>genericMethodCallWithExplicitParameter();
    }

    static <T> List<T> genericMethodCallWithExplicitParameter() {
        return new ArrayList<>();
    }

    static void instanceCreation() {
        // can't compile, top-level wildcards
//        new ArrayList<? extends Number>();

        // but nested wildcards are permitted
        ArrayList<List<? extends Number>> lists = new ArrayList<>();
    }
}


// Supertypes restrictions

// "No wildcard expected" compile error
//class A extends ArrayList<? extends Number> {}
class A extends ArrayList<List<? extends Number>> {}

// "No wildcard expected" compile error
//abstract class B implements List<?> {}
