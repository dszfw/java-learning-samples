package exmpls.initialization;

public class InitializationBlock {
    public static void main(String[] args) {
        A a1 = new A(333);
        A a2 = new A();
        System.out.println(a1);
        System.out.println(a2);
    }
}

class A {
    int x;
    int y;

    A() {
    }

    A(int x) {
        this.x = x;
    }

    {
        x = 111;
        y = 222;
    }

    @Override
    public String toString() {
        return "A{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}