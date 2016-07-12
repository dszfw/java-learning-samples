package naftalinwadler.generics.chapter5;

import java.util.ArrayList;
import java.util.List;

public class Unchecked {
//    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List raw = new ArrayList<String>();
        Object o = raw.get(0);
        // unchecked
        raw.add("123");
        // unchecked
        List<String> parametrized = raw;
    }
}
