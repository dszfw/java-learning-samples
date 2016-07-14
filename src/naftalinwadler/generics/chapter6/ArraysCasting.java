package naftalinwadler.generics.chapter6;

public class ArraysCasting {
    public static void simpleWrongCast() {
        Object[] objects = new Object[]{"one", "two"};
        // ClassCastException will be thrown in this line of the code
        String[] strings = (String[]) objects;
    }

    // T[] will be replaced to Object[] by erasure
    // ClassCastException will be thrown in client code
    public static <T> T[] wrongCastWithUnchecked() {
        Object[] objects = new Object[]{"one", "two"};
        // unchecked
        T[] ttt = (T[]) objects;
        return ttt;
    }

    public static void main(String[] args) {
        // ClassCastException
//        String[] strings = wrongCastWithUnchecked();
        Object[] objects = wrongCastWithUnchecked();
    }
}
