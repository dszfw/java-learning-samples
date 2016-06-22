package naftalinwadler.generics.chapter2;

import java.util.Arrays;
import java.util.List;

public class ArraysVsGenerics {
    static void covariantArrays() {
        Integer[] ints = new Integer[]{1, 2, 3};
        Number[] nums = ints;
        // run time java.lang.ArrayStoreException
        nums[2] = 3.14;
        System.out.println(ints); // "[1, 2, 3.14]" uh oh!
    }

    static void invariantGenerics() {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        // compile time error
//        List<Number> nums = ints;
//        nums.set(2, 3.14);
    }

    static void covariantGeneric() {
        List<Integer> ints = Arrays.asList(1,2,3);
        List<? extends Number> nums = ints;
        // compile-time error
//        nums.set(2, 3.14);
    }
}
