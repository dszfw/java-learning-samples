package java67.multithreading;

public class AboutJoin {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable(t1));
        Thread t3 = new Thread(new MyRunnable(t2));
        t1.start();
        t2.start();
        t3.start();
    }
}

class MyRunnable implements Runnable {
    private Thread t;

    public MyRunnable() {
    }

    public MyRunnable(Thread t) {
        this.t = t;
    }

    @Override
    public void run() {
        if (t != null) {
            try {
                System.out.println(Thread.currentThread().getId() + " is joining to " + t.getId());
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getId() + " is running");
    }
}