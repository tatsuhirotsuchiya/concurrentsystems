package day7.readerswrite;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Data {
    private final char[] buffer;
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock(false);
    private final Lock readlock = rwlock.readLock();
    private final Lock writelock = rwlock.writeLock();
 
    public Data(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '*';
        }
    }
    public char[] read() throws InterruptedException {
        readlock.lock();
        try {
            return doRead();
        } finally {
            readlock.unlock();
        }
    }
    public void write(char c) throws InterruptedException {
        writelock.lock();
        try {
            doWrite(c);
        } finally {
            writelock.unlock();
        }
    }
    private char[] doRead() {
        char[] newbuf = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newbuf[i] = buffer[i];
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
