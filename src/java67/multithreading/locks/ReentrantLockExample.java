package java67.multithreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        int time = 1000;
        Runnable lockedWork = () -> {
            lock.lock();
            try {
                lockByThread();
                doWork(time);
            } finally {
                unlockByThread();
                lock.unlock();
            }
        };
        doWorkByThreads(lockedWork, "locked");

        Runnable noLockedWork = () -> {
            lockByThread();
            doWork(time);
            unlockByThread();
        };
        doWorkByThreads(noLockedWork, "noLocked");
    }

    private static void doWork(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void doWorkByThreads(Runnable work, String prefix) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(work, prefix + "_" + i);
            t.start();
        }
    }

    private static void unlockByThread() {
        System.out.println("unlock by thread: " + getThreadName());
    }

    private static void lockByThread() {
        System.out.println("lock by thread: " + getThreadName());
    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }
}