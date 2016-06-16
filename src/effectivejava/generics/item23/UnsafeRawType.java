package effectivejava.generics.item23;

import java.util.ArrayList;
import java.util.List;

public class UnsafeRawType {
    // Uses raw type (List) - fails at runtime!
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, 42);
        // ClassCastException will be thrown
        String s = strings.get(0); // Compiler-generated cast

        // There are subtyping rules for generics
        // List<String> is subtype of raw type List
        List objects = strings;
        // but is not subtype of List<Object>
        // List<Object> objects = strings;
    }

    // we can do unsafe add
    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
