package exp;

public class SynchByLockInLexicalScope {
    public static void main(String[] args) {
        Object lock = new Object();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    doWork();
                }
            }
            private void doWork() {
                synchronized (lock) {
                    System.out.println("do do do by " + Thread.currentThread().getName());
                }
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
