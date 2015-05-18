package exmpls;

import java.lang.reflect.Field;

public class ReflectionPrivateAccess {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        My my = new My("mymymy");
        Class<? extends My> myClass = my.getClass();
        for (Field field : myClass.getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.get(my));
        }
    }
}

class My {
    public String publicField;
    private String privateField;

    public My(String s) {
        this.publicField = s + "_public";
        this.privateField = s + "_private";
    }
}
