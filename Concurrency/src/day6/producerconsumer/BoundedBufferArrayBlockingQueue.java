package day6.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;

public class BoundedBufferArrayBlockingQueue extends ArrayBlockingQueue<String> {
    public BoundedBufferArrayBlockingQueue(int count) {
        super(count);
    }
    public void put(String datum) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + datum);
        super.put(datum);
    }
    public String take() throws InterruptedException {
        String datum = super.take();
        System.out.println(Thread.currentThread().getName() + " takes " + datum);
        return datum;
    }
}
