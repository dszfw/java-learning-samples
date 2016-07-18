package naftalinwadler.generics.chapter8.legacy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class WaryClient {
    public static void processItems() {
        List<Integer> list = new ArrayList<>();
        List<Integer> view = Collections.checkedList(list, Integer.class);
        LegacyLibrary.addItems(view); // class cast exception
        // unchecked
        List<Integer> list2 = LegacyLibrary.getItems();
        // empty loop for guarantee
        for (int i : list2) {} // class cast exception
        // sometime later ...
        int s = 0;
        for (int i : list) s += i;
        for (int i : list2) s += i;
    }
}