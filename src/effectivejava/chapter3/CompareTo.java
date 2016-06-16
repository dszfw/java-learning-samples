package effectivejava.chapter3;

import java.math.BigDecimal;

public class CompareTo {

    public static void main(String[] args) {
        // false
        System.out.println(new BigDecimal("1.00").equals(new BigDecimal("1.0")));
        // 0
        System.out.println(new BigDecimal("1.00").compareTo(new BigDecimal("1.0")));
    }

}
