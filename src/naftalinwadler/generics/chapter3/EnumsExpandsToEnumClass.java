package naftalinwadler.generics.chapter3;

import java.io.Serializable;

public class EnumsExpandsToEnumClass {
    public static void main(String[] args) {
        System.out.println(Seasons.SUMMER instanceof Enum);
        Serializable[] values = Seasons.values();
        System.out.println(values);
    }
}

enum Seasons {
    WINTER, SPRING, SUMMER, FALL
}