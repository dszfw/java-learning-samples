package java67.top10tough;

public class IllegalMonitorState {
    public static void main(String[] args) {
        Object lock = new Object();

        new Thread(() -> {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(lock::notifyAll).start();
    }
}
