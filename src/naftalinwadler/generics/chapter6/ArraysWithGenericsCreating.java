package naftalinwadler.generics.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class ArraysWithGenericsCreating {
    /*public static <T> T[] createArrWithTypeParameter() {
        // illegal
        return new T[10];
    }*/

    public static <T> T[] castingArrWithTypeParameter() {
        // unchecked cast
        return (T[]) new Object[10];
    }

    /*public static List<Integer>[] createArrWithGeneric() {
        // illegal
        return new ArrayList<Integer>[10];
    }*/

    /*public static void creatingArrayNotReifiedType() {
        // illegal generic array creation
        List<Integer>[] lists = new List<Integer>[]{new ArrayList<>(), new ArrayList<>()};
    }*/

    public static List<List<Integer>> creatingArrNotReifiedTypeBySafeVarargs() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(4, 5, 6);
        // Arrays.asList uses @SafeVarargs since java 1.7
        return Arrays.asList(a, b);
    }

    // warning
    public static <E> void creatingArrNotReifiedTypeByVarargs(List<E>... args) {
        // heap pollution
        ((Object[])args)[0] = new ArrayList<Integer>();
    }
}
