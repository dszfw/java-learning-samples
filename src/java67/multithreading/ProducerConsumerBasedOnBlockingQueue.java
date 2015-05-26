package java67.multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBasedOnBlockingQueue {
    public static void main(String[] args) {
        final Random random = new Random();
        final BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue<>(10);

        Runnable producerRunnable = () -> {
            String threadName = Thread.currentThread().getName();
            while (!Thread.currentThread().isInterrupted()) {
                int i = random.nextInt();
                try {
                    Thread.sleep(1000);
                    sharedQueue.put(i);
                    System.out.println(threadName + " produced: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumerRunnable = () -> {
            String threadName = Thread.currentThread().getName();
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(700);
                    Integer i = sharedQueue.take();
                    System.out.println(threadName + " consumed: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(producerRunnable).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(consumerRunnable).start();
        }
    }
}
