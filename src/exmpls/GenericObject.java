package exmpls;

import java.util.ArrayList;
import java.util.List;

public class GenericObject {
    public static void main(String[] args) {
        List<? extends Parent> list = new ArrayList<>();
//        list.add(new Child());

        new GenericExmpl().print("dadasd");
    }
}

class Parent {

}

class Child extends Parent {

}

class GenericExmpl {
    <Generic> void print(Generic g) {
        System.out.println(g.getClass());
    }
}

