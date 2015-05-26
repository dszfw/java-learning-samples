package java67.multithreading.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class FixedDeadLock {
    public static void main(String[] args) {
        LockHolder lockHolder1 = new LockHolder("Lock_1", new ReentrantLock());
        LockHolder lockHolder2 = new LockHolder("Lock_2", new ReentrantLock());

        Thread t1 = new Thread(new NonBlockingWork(lockHolder1, lockHolder2));
        Thread t2 = new Thread(new NonBlockingWork(lockHolder2, lockHolder1));

        t1.start();
        t2.start();
    }
}

class NonBlockingWork extends Work {
    private LockHolder lockHolder1;
    private LockHolder lockHolder2;

    public NonBlockingWork(LockHolder lockHolder1, LockHolder lockHodler2) {
        super(lockHolder1, lockHodler2);
        this.lockHolder1 = lockHolder1;
        this.lockHolder2 = lockHodler2;
    }

    @Override
    public void run() {
        while (true) {
            try {


                if (lockHolder1.lock.tryLock(500L, TimeUnit.MILLISECONDS)) {
                    try {
                        printLockSuccesfull(lockHolder1.name);
                        if (lockHolder2.lock.tryLock(1L, TimeUnit.SECONDS)) {
                            try {
                                printLockSuccesfull(lockHolder2.name);
                                doWork();
                            } finally {
                                lockHolder2.lock.unlock();
                                printUnLock(lockHolder2.name);
                            }
                        } else {
                            printLockFailed(lockHolder2.name);
                        }
                    } finally {
                        lockHolder1.lock.unlock();
                        printUnLock(lockHolder1.name);
                    }
                } else {
                    printLockFailed(lockHolder1.name);
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}