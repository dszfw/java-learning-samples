package exp;

public class Closure {
    int x;
    final int y = 0;
    private int z = 0;

    void doSome() {
        int l = 0;
        {
            final int[] c = {0};
            final int k = 0;
            doA(() -> {
                System.out.println(l);
                System.out.println(x++);
                System.out.println(y);
                System.out.println(c[0]++);
                System.out.println(k);
                System.out.println(z);
            });
        }
    }

    void doA(A a) {}
}

interface A {
    void doWork();
}