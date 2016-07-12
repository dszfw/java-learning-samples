package naftalinwadler.generics.chapter4;

import java.util.ArrayList;
import java.util.List;

public class StaticMembers {
}

class Cell2<T> {
    private final T value;
    private static List<Object> values = new ArrayList<>(); // <T> illegal
    public Cell2(T value) {
        this.value=value;
        values.add(value);
    }
    public T getValue() {
        return value;
    }
    public static List<Object> getValues() { // <T> illegal
        return values;
    }
}
