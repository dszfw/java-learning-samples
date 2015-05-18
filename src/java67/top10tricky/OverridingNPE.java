package java67.top10tricky;

import java.io.IOException;

public class OverridingNPE {

    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = new Parent();
        try {
            child.doSome();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Parent {
        void doSome() throws IOException, NullPointerException{
            throw new NullPointerException();
        }
    }

    static class Child extends Parent{
        void doSome() throws IOException, RuntimeException {

        }
    }
}