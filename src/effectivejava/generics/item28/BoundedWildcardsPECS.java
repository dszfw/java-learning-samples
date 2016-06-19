package effectivejava.generics.item28;

import java.util.ArrayList;
import java.util.List;

public class BoundedWildcardsPECS {

    static void genericInvariantUsage() {
        List<Object> objectList = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        // Incompatible types
//        objectList = strings;
        objectList.add(42);
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
