package naftalinwadler.generics.chapter8.legacy;

import java.util.ArrayList;
import java.util.List;

class NaiveClient {
    public static void processItems() {
        List<Integer> list = new ArrayList<>();
        LegacyLibrary.addItems(list);
        // unchecked
        List<Integer> list2 = LegacyLibrary.getItems();
        // sometime later ...
        int s = 0;
        for (int i : list) s += i; // class cast exception
        for (int i : list2) s += i; // class cast exception
    }
}