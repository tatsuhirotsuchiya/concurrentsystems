package day6.producerconsumer;

import java.util.concurrent.*;

public class BoundedBuffer {
    private final String[] buffer;
    private int tail;
    private int head;
    private final Semaphore slots, items;
    public BoundedBuffer(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.slots = new Semaphore(buffer.length, true);
        this.items = new Semaphore(0, true);
    }

    public void put(String datum) throws InterruptedException {
        slots.acquire();
        // Thread.sleep(100); //choice 1
        
        System.out.println(Thread.currentThread().getName() + " puts " + datum);
        buffer[tail] = datum;
        
        // Thread.sleep(100); //choice 2
        
        tail = (tail + 1) % buffer.length;
        
        Thread.sleep(100); //choice 3
        
        items.release();
    }

    public String take() throws InterruptedException {
    	items.acquire();
        String datum = buffer[head];
        head = (head + 1) % buffer.length;
        System.out.println(Thread.currentThread().getName() + " takes " + datum);
        slots.release();
        return datum;
    }
}
