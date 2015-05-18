package java67.top10tough.singleton;

import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Singletones {
    public static void main(String[] args) throws InterruptedException {
        // Test for one thread
        HashSet<NotSafeSingleton> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            NotSafeSingleton singleton = NotSafeSingleton.getInstance();
            set.add(singleton);
        }
        System.out.println(set);

        NotSafeSingleton.refresh();

        /*// Test NotSafeSingleton for many threads
        final HashSet<NotSafeSingleton> set2 = new HashSet<>();
        Runnable notSafeSingletonRunnable = new Runnable() {
            @Override
            public void run() {
                NotSafeSingleton instance = NotSafeSingleton.getInstance();
                set2.add(instance);
                // System.out.println("done");
            }
        };
        do {
            set2.clear();
            testOnThreads(notSafeSingletonRunnable, 1_000_000);
        } while (set2.size() < 2);
        System.out.println(set2);*/

        /*// Test OCLSingleton for many threads
        final HashSet<OCLSingleton> set3 = new HashSet<>();
        Runnable oneCheckLockSingletonRunnable = new Runnable() {
            @Override
            public void run() {
                OCLSingleton instance = OCLSingleton.getInstance();
                set3.add(instance);
                // System.out.println("done");
            }
        };
        do {
            set3.clear();
            testOnThreads(oneCheckLockSingletonRunnable, 1_000_000);
        } while (set3.size() < 2);
        System.out.println(set3);*/

        // Test BrokenDCLSingleton for many threads
        final Map<String, BrokenDCLSingleton> map = new ConcurrentHashMap<>();
        Runnable dclSingletonRunnable = new Runnable() {
            @Override
            public void run() {
                BrokenDCLSingleton instance = BrokenDCLSingleton.getInstance();
                map.put(instance.toString(), instance);
                // System.out.println("done");
            }
        };
        do {
            System.out.println("do");
            map.clear();
            testOnThreads(dclSingletonRunnable, 1_000_000);
//            Thread.sleep(20_000);
        } while (map.size() < 2);
        System.out.println(map);
    }

    private static void testOnThreads(Runnable runnable, long count) throws InterruptedException {
        HashSet<Thread> threads = new HashSet<>();
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
            thread.start();
        }
    }
}

class NotSafeSingleton {
    private static NotSafeSingleton instance;

    private NotSafeSingleton() {
    }

    public static NotSafeSingleton getInstance() {
        if (instance == null) {
            instance = new NotSafeSingleton();
        }
        return instance;
    }

    public static void refresh() {
        instance = null;
    }
}

class OCLSingleton {
    private static OCLSingleton instance = null;

    private OCLSingleton() {
    }

    public static OCLSingleton getInstance() {
        if (instance == null) {
            synchronized (OCLSingleton.class) {
                instance = new OCLSingleton();
            }
        }
        return instance;
    }
}

/**
 * Double checked locking singleton
 * broken version
 */
class BrokenDCLSingleton {
    private static BrokenDCLSingleton instance = null;
    // It seems counter also should be volatile
    private static int counter;
    private int id;

    private BrokenDCLSingleton() {
        counter++;
        id = counter;
    }

    public static BrokenDCLSingleton getInstance() {
        if (instance == null) {
            synchronized (BrokenDCLSingleton.class) {
                if (instance == null) {
                    instance = new BrokenDCLSingleton();
                }
            }
        }
        return instance;
    }

    @Override
    public String toString() {
        return "BrokenDCLSingleton{" +
                "id=" + id +
                '}';
    }
}

/**
 * Double checked locking singleton
 * fixed version
 */
class FixedDCLSingleton {
    private static volatile FixedDCLSingleton instance = null;

    private FixedDCLSingleton() {
    }

    public static FixedDCLSingleton getInstance() {
        if (instance == null) {
            synchronized (FixedDCLSingleton.class) {
                if (instance == null) {
                    instance = new FixedDCLSingleton();
                }
            }
        }
        return instance;
    }
}