package exmpls.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvoke {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        SomeChild child = new SomeChild(22);
        child.useParentPrivateMethod();
    }
}

class SomeParent {
    private int x;

    public SomeParent(int x) {
        this.x = x;

    }

    private void printParentX() {
        System.out.println("X: " + x);
    }
}

class SomeChild extends SomeParent {

    public void useParentPrivateMethod() throws InvocationTargetException, IllegalAccessException {
        Class parentClass = this.getClass().getSuperclass();
        Method[] methods = parentClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals("printParentX")) {
                method.setAccessible(true);
                method.invoke(this);
            }
        }
    }

    public SomeChild(int x) {
        super(x);
    }
}