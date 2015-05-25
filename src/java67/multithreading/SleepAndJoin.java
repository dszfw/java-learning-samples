package java67.multithreading;

public class SleepAndJoin {
    public static void main(String[] args) throws InterruptedException {
        int time = 1000;
        Thread thread = new Thread(() -> {
            System.out.println("doing");
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("done");
        });
        thread.start();
        // .join() should be used for already started thread
        thread.join();
        System.out.println("end");
    }
}
