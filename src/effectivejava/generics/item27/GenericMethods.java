/*
package effectivejava.generics.item27;

import java.util.*;

public class GenericMethods {
    public static void main(String[] args) {
        Car bmw = new Car("e39", 5000);
        Phone samsung = new Phone("a3", 250);
        Money cash = new Money(6000);
        List<Comparable<Money>> valuableThings
                = new ArrayList<>(Arrays.asList(bmw, samsung, cash));

        max(valuableThings);
        System.out.println();
    }

    // TODO
    public static <T extends Comparable<Money>> T max(List<T> list) {
        Iterator<T> i = list.iterator();
        T result = i.next();
        while (i.hasNext()) {
            T t = i.next();
            if (t.compareTo(result) > 0)
                result = t;
        }
        return result;
    }
}

class Car implements Comparable<Money>{
    private final String name;
    private final long value;

    public Car(String name, long value) {
        if (value < 0) {
            throw new IllegalArgumentException("money value is negative");
        }
        this.name = name;
        this.value = value;
    }

    @Override
    public int compareTo(Money o) {
        return (int) (this.value - o.getAmount());
    }
}

class Phone implements Comparable<Money> {
    private final String name;
    private final long value;

    public Phone(String name, long value) {
        if (value < 0) {
            throw new IllegalArgumentException("money value is negative");
        }
        this.name = name;
        this.value = value;
    }

    @Override
    public int compareTo(Money o) {
        return (int) (this.value - o.getAmount());
    }
}

final class Money implements Comparable<? extends Comparable<Money>> {
    private final long amount;

    public Money(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("money value is negative");
        }
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

}*/
