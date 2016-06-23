package naftalinwadler.generics.chapter3;

import java.util.*;

public class CollectionMaxComparator {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("123", "12345", "12");

        String max = getMax(strings, (s1, s2) ->
                s1.length() > s2.length() ? 1 :
                        s1.length() < s2.length() ? -1 :
                                s1.compareTo(s2)
        );

        System.out.println(max);
    }

    static <T> T getMax(Collection<? extends T> collection, Comparator<? super T> cmp) {
        Iterator<? extends T> it = collection.iterator();
        T candidate = it.next();
        while (it.hasNext()) {
            T el = it.next();
            if (cmp.compare(candidate, el) < 0) {
                candidate = el;
            }
        }
        return candidate;
    }
}
