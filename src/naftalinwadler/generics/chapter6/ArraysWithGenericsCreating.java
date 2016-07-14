package naftalinwadler.generics.chapter6;

import java.util.ArrayList;
import java.util.List;

public class ArraysWithGenericsCreating {
    /*public static <T> T[] createArrWithTypeParameter() {
        // illegal
        return new T[10];
    }*/

    public static <T> T[] createArrWithTypeParameter2() {
        // unchecked
        return (T[]) new Object[10];
    }

    /*public static List<Integer>[] createArrWithGeneric() {
        // illegal
        return new ArrayList<Integer>[10];
    }*/
}
