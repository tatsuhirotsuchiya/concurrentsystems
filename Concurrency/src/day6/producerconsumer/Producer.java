package day6.producerconsumer;

import java.util.Random;

public class Producer extends Thread {
    private final Random random;
    private final BoundedBuffer buffer;
    private static int id = 0; 
    public Producer(String name, BoundedBuffer buffer, long seed) {
        super(name);
        this.buffer = buffer;
        this.random = new Random(seed);
    }
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(600));
                String datum = "[ Item No." + nextId() + " by " + getName() + " ]";
                buffer.put(datum);
            }
        } catch (InterruptedException e) {
        }
    }
    private static synchronized int nextId() {
        return id++;
    }
}
