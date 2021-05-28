package day7.producerconsumer;

public class BoundedBufferWN {
    private final String[] buffer;
    private int tail;
    private int head;
    private int count;
    public BoundedBufferWN(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public synchronized void put(String datum) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + datum);
        while (count >= buffer.length) {
            wait();
        }
        buffer[tail] = datum;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            wait();
        }
        String datamu = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + datamu);
        return datamu;
    }
}
