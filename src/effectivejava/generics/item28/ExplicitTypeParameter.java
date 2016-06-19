package effectivejava.generics.item28;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExplicitTypeParameter {
    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<Integer>(Arrays.asList(3, 16, 42));
        Set<Double> doubles = new HashSet<Double>(Arrays.asList(3.0, 16.0, 42.0));

        // won't compile on java 1.7 and lower
        // the type inference rules are quite complex, and they don’t always
        // do what you want them to. Luckily there is a way to deal with this
        // sort of error. If the compiler doesn’t infer the type that you wish
        // it had, you can tell it what type to use with an explicit type parameter
        // ExplicitTypeParameter.<Number>union(integers, doubles)
        Set<Number> numbers = union(integers, doubles);
    }

    static <T> Set<T> union(Set<? extends T> set1, Set<? extends T> set2) {
        return null;
    }
}
