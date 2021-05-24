package day6.producerconsumer;

public class BoundedBufferBusy {
    private final String[] buffer;
    private int tail;
    private int head;
    private int count;
    public BoundedBufferBusy(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public synchronized boolean put(String datum) {
    	if (count >= buffer.length) {
    		return false;
    	}
        System.out.println(Thread.currentThread().getName() + " puts " + datum);
        buffer[tail] = datum;
        tail = (tail + 1) % buffer.length;
        count++;
        return true;
    }

    public synchronized String take() {
        if (count <= 0) {
            return null;
        }
        String datum = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        System.out.println(Thread.currentThread().getName() + " takes " + datum);
        return datum;
    }
}
