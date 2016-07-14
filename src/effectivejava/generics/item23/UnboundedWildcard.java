package effectivejava.generics.item23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnboundedWildcard {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("ssss");

        List<?> unboundedWildcardList = Arrays.asList("one", "two");
        // we can't add any element to unboundedWildcardList except null
//         unboundedWildcardList.add("sss");
        // unboundedWildcardList.add(123);
        // unboundedWildcardList.add(true);
        unboundedWildcardList.add(null);
        Object o = unboundedWildcardList.get(0);
        System.out.println(unboundedWildcardList.size());

        Www<String> stringWww = new Www<>("123");
        stringWww.showW("ololo");
        Www<?> www = stringWww;
        // put
//        www.showW("1321");
        // get
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