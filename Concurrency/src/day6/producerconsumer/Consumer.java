package day6.producerconsumer;

import java.util.Random;

public class Consumer extends Thread {
    private final Random random;
    private final BoundedBuffer buffer;
    public Consumer(String name, BoundedBuffer buffer, long seed) {
        super(name);
        this.buffer = buffer;
        this.random = new Random(seed);
    }
    public void run() {
        try {
            while (true) {
                String datum = buffer.take();
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
        }
    }
}
