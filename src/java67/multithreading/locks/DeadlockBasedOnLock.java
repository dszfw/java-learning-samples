package java67.multithreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Expected result for thread dump:
 *
 * Found one Java-level deadlock:
 * =============================
 * "Thread-1":
 * waiting for ownable synchronizer 0x0000000780a5c418, (a java.util.concurrent.locks.ReentrantLock$NonfairSync),
 * which is held by "Thread-0"
 * "Thread-0":
 * waiting for ownable synchronizer 0x0000000780a5c498, (a java.util.concurrent.locks.ReentrantLock$NonfairSync),
 * which is held by "Thread-1"
 */
public class DeadlockBasedOnLock {
    public static void main(String[] args) {
        LockHolder lockHolder1 = new LockHolder("Lock_1", new ReentrantLock());
        LockHolder lockHolder2 = new LockHolder("Lock_2", new ReentrantLock());

        Thread t1 = new Thread(new Work(lockHolder1, lockHolder2));
        Thread t2 = new Thread(new Work(lockHolder2, lockHolder1));

        t1.start();
        t2.start();
    }
}

class Work implements Runnable {
    private LockHolder lockHolder1;
    private LockHolder lockHodler2;

    public Work(LockHolder lockHolder1, LockHolder lockHodler2) {
        this.lockHolder1 = lockHolder1;
        this.lockHodler2 = lockHodler2;
    }

    @Override
    public void run() {
        while (true) {
            lockHolder1.lock.lock();
            printLockSuccesfull(lockHolder1.name);
            try {
                lockHodler2.lock.lock();
                printLockSuccesfull(lockHodler2.name);
                try {
                    doWork();
                } finally {
                    lockHodler2.lock.unlock();
                    printUnLock(lockHodler2.name);
                }
            } finally {
                lockHolder1.lock.unlock();
                printUnLock(lockHolder1.name);
            }
        }
    }

    public static void printUnLock(String lockName) {
        System.out.println("unlock " + lockName + " by " + Thread.currentThread().getName());
    }

    public static void printLockSuccesfull(String lockName) {
        System.out.println("lock " + lockName + " by " + Thread.currentThread().getName());
    }

    public static void printLockFailed(String lockName) {
        System.out.println("lock is failed " + lockName + " by " + Thread.currentThread().getName());
    }

    public static void doWork() {
        System.out.println("do work by " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class LockHolder {
    public String name;
    public Lock lock;

    public LockHolder(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
    }
}