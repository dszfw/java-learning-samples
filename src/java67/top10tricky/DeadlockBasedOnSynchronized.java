package java67.top10tricky;

public class DeadlockBasedOnSynchronized {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (String.class) {
                    print(String.class);
                    synchronized (Integer.class) {
                        print(Integer.class);
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (Integer.class) {
                    print(Integer.class);
                    synchronized (String.class) {
                        print(String.class);
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

    private static void print(Class aClass) {
        System.out.println("Lock on " + aClass.getSimpleName() + " by " + Thread.currentThread().getName());
    }
}
