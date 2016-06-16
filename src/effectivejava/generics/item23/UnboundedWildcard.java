package effectivejava.generics.item23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnboundedWildcard {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("ssss");

        List<?> wildcardList = new ArrayList<>(Arrays.asList("one", "two"));
        // we can't add any element to wildcardList except null
//         wildcardList.add("sss");
        // wildcardList.add(123);
        // wildcardList.add(true);
        wildcardList.add(null);
        Object o = wildcardList.get(0);
        System.out.println(wildcardList.size());

        Www<String> stringWww = new Www<>("123");
        stringWww.showW("ololo");
        Www<?> www = stringWww;
//        www.showW("1321");
        Object w = www.getW();
        System.out.println(w);
        System.out.println(w instanceof String);
        System.out.println(w.getClass());
    }
}

class Www <W> {
    private W w;

    public Www(W w) {
        this.w = w;
    }

    public void showW(final W w) {
        System.out.println(w);
    }

    public W getW() {
        return w;
    }
}