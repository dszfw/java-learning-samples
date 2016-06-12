package jdk8;

import java.util.Optional;

public class OptionalSample {
    public static void main(String[] args) {
        Optional<Integer> integerOptional1 = Optional.of(1234);
        System.out.println(integerOptional1);

        Optional<Integer> integerOptional2 = Optional.empty();
        Optional<Integer> integerOptional4 = Optional.ofNullable(1234);
        Optional<Integer> integerOptional3 = Optional.ofNullable(null);
    }
}