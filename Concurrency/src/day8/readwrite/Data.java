package day8.readwrite;

public class Data {
    private final char[] buffer;
    private final ReadWriteLock lock = new RWLockLive();
    
    public Data(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '*';
        }
    }
    public char[] read() throws InterruptedException {
        lock.acquireRead();
        try {
            return doRead();
        } finally {
            lock.releaseRead();
        }
    }
    public void write(char c) throws InterruptedException {
        lock.acquireWrite();
        try {
            doWrite(c);
        } finally {
            lock.releaseWrite();
        }
    }
    private char[] doRead() {
        char[] newbuf = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newbuf[i] = buffer[i];
            slowly();
        }
        slowly();
        return newbuf;
    }
    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            slowly();
        }
    }
    private void slowly() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
    }
}
