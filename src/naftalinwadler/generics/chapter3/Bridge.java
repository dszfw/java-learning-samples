package naftalinwadler.generics.chapter3;

import java.lang.reflect.Method;

public class Bridge {
    public static void main(String[] args) {
        // bridge usage #1
        for (Method m : Integer.class.getMethods())
            if (m.getName().equals("compareTo"))
                System.out.println(m.toGenericString());

        // bridge usage #2
        for (Method m : Point.class.getDeclaredMethods())
            if (m.getName().equals("clone")) {
                System.out.println(m.toGenericString());
            }
    }
}

class Point {
    int x;
    int y;

    @Override
    // Object return type -> Point
    protected Point clone() throws CloneNotSupportedException {
        return (Point) super.clone();
    }
}