package naftalinwadler.generics.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Principle of Indecent Exposure:
 * never publicly expose an array where the components
 * do not have a reifiable type.
 */
public class IndecentExposurePrinciple {
    public static void main(String[] args) {
        // Arrays using
        List<Integer>[] integerLists = doExposeArrayWithNotReifiableComponent();
        List<? extends Number>[] numberLists = integerLists;
        numberLists[0] = Arrays.asList(2.718, 3.14);
        // ClassCastException
        Integer integer = integerLists[0].get(0);

        // Collections using
        List<List<Integer>> integerLists2 = doExposeCollectionWithNotReifiableComponent();
        List<? extends List<? extends Number>> numberLists2 = integerLists2;
        // generics prevents previous trouble
        // illegal
//        numberLists2.set(0, new ArrayList<Double>());
    }

    // principle violated
    public static <T> List<T>[] doExposeArrayWithNotReifiableComponent() {
        // unchecked
        return (List<T>[]) new List[10];
    }

    public static <T> List<List<T>> doExposeCollectionWithNotReifiableComponent() {
        return Arrays.asList(new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>());
    }
}
