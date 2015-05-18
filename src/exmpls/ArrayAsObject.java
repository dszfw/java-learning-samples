package exmpls;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayAsObject {
    public static void main(String[] args) {
        int[] ints1 = {1, 2, 3, 4, 5};
        int[] ints2 = {1, 2, 3, 4, 5};
        double[] doubles = {1.11, 1.23};

        System.out.println(ints1.equals(ints2));
        System.out.println(Arrays.equals(ints1, ints2));
//        System.out.println(ints1.toString());
//        System.out.println(doubles.toString());

        Set set = new HashSet(Arrays.asList(ints1, ints2));
        System.out.println(set);
    }
}