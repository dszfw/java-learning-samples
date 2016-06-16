package effectivejava.generics.item24;


import java.util.HashSet;
import java.util.Set;

public class UncheckedWarning {
    public static void main(String[] args) {
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
}
