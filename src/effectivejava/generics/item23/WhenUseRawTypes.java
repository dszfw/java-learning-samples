package effectivejava.generics.item23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WhenUseRawTypes {
    public static void main(String[] args) {
        System.out.println(List.class);
        // generic type information is erased at runtime
//        System.out.println(List<String>.class);

        List<String> stringList = new ArrayList<>();
        System.out.println(stringList instanceof LinkedList);
    }
}
