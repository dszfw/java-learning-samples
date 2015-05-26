package java67.multithreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Lock w = lock.writeLock();
        Lock r = lock.readLock();

        Thread writer = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("W attempt to lock by " + threadName);
            w.lock();
            try {
                System.out.println("W locked by " + threadName);
                System.out.println("writing by " + threadName);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                w.unlock();
                System.out.println("W unlocked by " + threadName);
            }
        });

        Runnable readerRunnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("R attempt to lock by " + threadName);
            r.lock();
            try {
                System.out.println("R locked by " + threadName);
                System.out.println("reading by " + threadName);
            } finally {
                r.unlock();
                System.out.println("R unlocked by " + threadName);
            }
        };

        writer.start();
        for (int i = 0; i < 5; i++) {
            new Thread(readerRunnable).start();
        }
    }
}

/* OUTPUT -----------------------------------

        W attempt to lock by Thread-0
        W locked by Thread-0
        writing by Thread-0
        R attempt to lock by Thread-3
        R attempt to lock by Thread-4
        R attempt to lock by Thread-1
        R attempt to lock by Thread-2
        R attempt to lock by Thread-5
        W unlocked by Thread-0
        R locked by Thread-4
        reading by Thread-4
        R unlocked by Thread-4
        R locked by Thread-3
        reading by Thread-3
        R locked by Thread-1
        reading by Thread-1
        R unlocked by Thread-3
        R locked by Thread-5
        R locked by Thread-2
        reading by Thread-2
        R unlocked by Thread-2
        R unlocked by Thread-1
        reading by Thread-5
        R unlocked by Thread-5

        Process finished with exit code 0*/
