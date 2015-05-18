package exmpls;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListAdding {
    public static void main(String[] args) {
        List<B> bList = new ArrayList<>();
        B b = new B(222);
        bList.add(b);
        bList.add(b);
        bList.add(b);
        bList.add(null);
        System.out.println(bList);

        Set<B> bSet = new HashSet<>();
        bSet.add(b);
        bSet.add(b);
        bSet.add(b);
        bSet.add(null);
        System.out.println(bSet);
    }
}

class B {
    private int x;

    public B(int x) {
        this.x = x;
    }
}
