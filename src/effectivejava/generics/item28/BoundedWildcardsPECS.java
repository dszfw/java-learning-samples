package effectivejava.generics.item28;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BoundedWildcardsPECS {

    static void genericInvariantUsage() {
        List<Object> objectList = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        // Incompatible types
//        objectList = strings;
        objectList.add(42);
    }

    // covariant usage
    static void genericBoundedUsage() {
        List<Object> listObjects = new ArrayList<>();
        listObjects.add(new Object());
        listObjects.add(Integer.valueOf(42));

        List<? super String> listObjects2 = new ArrayList<>();
        listObjects2.add(new Object());
        listObjects2.add("123412");
        Object o = listObjects2.get(0);
        listObjects2 = new ArrayList<Object>();

    }

    // PECS - producer - extends, consumer - super
    static <T> List<T> genericProducerUsage(List<? extends T> producer) {
        List<T> list = new ArrayList<>();

        // won't compile
//        producer.add(list.get(0));

        // GET from Producer
        for (T t : producer) {
            list.add(t);
        }
        return list;
    }

    static <T> void genericConsumerUsage(List<? super T> consumer) {
        List<T> list = new ArrayList<>();

        // won't compile
//        list.add(consumer.get(0));

        for (T t : list) {
            // PUT to Consumer
            consumer.add(t);
        }
    }
}
