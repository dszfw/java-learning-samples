package java67.top10tricky;

public class StaticMethodOverride {
    public static void main(String[] args) {
        Parent child = new Child();
        child.doSome();
    }
}

class Parent {
    public static void doSome() {
        System.out.println("doSome parent");
    }
}

class Child extends Parent {
    public static void doSome() {
        System.out.println("doSome child");
    }
}