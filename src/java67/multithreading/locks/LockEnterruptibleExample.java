package java67.multithreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockEnterruptibleExample {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Runnable runnable = () -> {
            while (true) {
                try {
                    System.out.println("try lock");
                    lock.lockInterruptibly();
                    System.out.println("locked");
                    try {
                        System.out.println("do work");
                    } finally {
                        lock.unlock();
                        System.out.println("unlocked");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500L);
        thread.interrupt();
    }
}
