package java67.top10tough;

public class ReferenceOrValue {
    public static void main(String[] args) {
        Child child = new Child();
        Parent p = child;
        System.out.println(p.getClass());
    }
}

class Parent {}

class Child extends Parent {}