package naftalinwadler.generics.chapter3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionMaxComparable {

    public static void main(String[] args) {
        List<Orange> oranges = Arrays.asList(new Orange(), new Orange());
        // Orange extends Fruit implements Comparable<Fruit>
        Orange maxOrange = getMax(oranges);
        // can't compile, Orange should implement Comparable<Orange> instead of extending Fruit
//        getMaxSimple(oranges);

        List<Fruit> fruits = Arrays.asList(new Apple(), new Orange());
        Fruit maxFruit = getMax(fruits);

        List<Vehicle> vehicles = Arrays.asList(new Jet(), new Car());
        // can't compile, isn't in bound
//        getMax(vehicles);
        List<Car> cars = Arrays.asList(new Car(), new Car());
        Car maxCar = getMaxSimple(cars);
    }

    static <T extends Comparable<? super T>> T getMax(Collection<? extends T> collection) {
        Iterator<? extends T> it = collection.iterator();
        T candidate = it.next();
        while (it.hasNext()) {
            T el = it.next();
            if (candidate.compareTo(el) < 0) {
                candidate = el;
            }
        }
        return candidate;
    }

    static <T extends Comparable<T>> T getMaxSimple(Collection<T> collection) {
        Iterator<T> it = collection.iterator();
        T candidate = it.next();
        while (it.hasNext()) {
            T el = it.next();
            if (candidate.compareTo(el) < 0) {
                candidate = el;
            }
        }
        return candidate;
    }


    // first case, not consistent with equals
    static class Fruit implements Comparable<Fruit> {
        @Override
        public int compareTo(Fruit o) {
            return 0;
        }
    }
    static class Orange extends Fruit {}
    static class Apple extends Fruit {}

    // second case
    static class Vehicle {}
    static class Jet extends Vehicle implements Comparable<Jet> {
        @Override
        public int compareTo(Jet o) {
            return 0;
        }
    }
    static class Car extends Vehicle implements Comparable<Car> {
        @Override
        public int compareTo(Car o) {
            return 0;
        }
    }
}