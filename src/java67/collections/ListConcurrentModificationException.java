package java67.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListConcurrentModificationException {
    public static void main(String[] args) {
        String s = "123";
        List<String> list = new ArrayList<>(Arrays.asList(s, "1234", "wert", "ololo"));
        Iterator<String> iterator = list.iterator();
        // Iterator of both LinkedList and ArrayList are fail-fast which means they will throw
        // ConcurrentModificationException if collection is modified structurally once Iterator is created.
        list.remove(0);
        System.out.println(iterator.next());
    }
}
