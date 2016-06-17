package effectivejava.generics.item24;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UncheckedWarning {
    public static void main(String[] args) {
        Set<String> strings = unionGeneric(new HashSet<>(Arrays.asList("one", "two")),
                new HashSet<>(Arrays.asList("three", "four")));

    }

    private static void suppressUncecked() {
    /*
    $ javac src/Main.java -Xlint:unchecked
    src\Main.java:6: warning: [unchecked] unchecked conversion
            Set<String> strings = new HashSet();
                                  ^
      required: Set<String>
      found:    HashSet
    1 warning
     */
        // wrong usage! use only with proved typesafe
        @SuppressWarnings("unchecked")
        Set<String> strings = new HashSet();
    }

    // Uses raw types - unacceptable! (Item 23)
    public static Set unionRaw(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    // Generic method
    public static <E> Set<E> unionGeneric(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
}
