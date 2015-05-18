package java67.top10tough;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ProducerConsumer {
    public static void main(String[] args) {
        Queue<Integer> doubleBlockingBuffer = new ConcurrentLinkedDeque<>();
        int size = 25;
        for (int i = 0; i < 3; i++) {
            Thread p = new Thread(new Producer(doubleBlockingBuffer, size));
            p.start();
        }
        for (int i = 0; i < 10; i++) {
            Thread c = new Thread(new Consumer(doubleBlockingBuffer));
            c.start();
        }
    }
}

class Producer implements Runnable {
    private static int counter;
    private int id;
    private Random randomizer;
    private final Queue<Integer> dbb;
    private int size;

    public Producer(Queue<Integer> doubleBlockingBuffer, int size) {
        this.dbb = doubleBlockingBuffer;
        this.size = size;
        this.id = counter;
        counter++;
        randomizer = new Random();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (dbb) {
                while (dbb.size() >= this.size) {
                    System.out.println(toString() + " is waiting");
                    try {
                        dbb.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int producedInt = randomizer.nextInt();
                System.out.println(toString() + " produced " + producedInt);
                dbb.add(producedInt);
                dbb.notifyAll();
                try {
                    dbb.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "_" + this.id;
    }
}

class Consumer implements Runnable {
    private static int counter;
    private int id;
    private final Queue<Integer> dbb;

    public Consumer(Queue<Integer> dbb) {
        this.dbb = dbb;
        this.id = counter;
        counter++;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (dbb) {
                while (dbb.size() == 0) {
                    System.out.println(toString() + " is waiting");
                    try {
                        dbb.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer consumedInt = dbb.poll();
                System.out.println(toString() + " consumed " + consumedInt);
                dbb.notifyAll();
                try {
                    dbb.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "_" + this.id;
    }
}