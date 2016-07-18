package naftalinwadler.generics.chapter8.legacy;

import java.util.ArrayList;
import java.util.List;

class LegacyLibrary {
    public static void addItems(List list) {
        list.add(1);
        list.add("two");
    }

    public static List getItems() {
        List list = new ArrayList();
        list.add(3);
        list.add("four");
        return list;
    }
}