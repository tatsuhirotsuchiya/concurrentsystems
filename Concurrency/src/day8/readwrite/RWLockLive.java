package day8.readwrite;

public final class RWLockLive implements ReadWriteLock {
	private int readingReaders = 0; 
	private int writingWriters = 0; 
	private int waitingWriters = 0;
	private boolean isReadersTurn = false;
	
	public synchronized void acquireRead() throws InterruptedException {
		while (writingWriters > 0 || (waitingWriters > 0 && !isReadersTurn)) {
			wait();
		}
		readingReaders++;
	}

	public synchronized void releaseRead() {
		readingReaders--;   
		isReadersTurn = false;
		notifyAll();
	}

	public synchronized void acquireWrite() throws InterruptedException {
		waitingWriters++;
		while (readingReaders > 0 || writingWriters > 0) {
			wait();
		}
		waitingWriters--;
		writingWriters++; 
	}

	public synchronized void releaseWrite() {
		writingWriters--;   
		isReadersTurn = true;
		notifyAll();
	}
}
