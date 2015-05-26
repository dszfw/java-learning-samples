package java67.multithreading;

public class ThreadInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("do");
            }
        });

        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
