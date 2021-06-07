package day8.readwrite;

public final class RWLock1 implements ReadWriteLock {
    private int readingReaders = 0; 
    private int writingWriters = 0; 

    public synchronized void acquireRead() throws InterruptedException {
        while (writingWriters > 0) {
            wait();
        }
        readingReaders++;              
    }

    public synchronized void releaseRead() {
        readingReaders--;   
        notifyAll();
    }

    public synchronized void acquireWrite() throws InterruptedException {
        while (writingWriters > 0) {
            wait();
        }
        writingWriters++; 
    }

    public synchronized void releaseWrite() {
        writingWriters--;                      
        notifyAll();
    }
}
