package day8.readwrite;

public interface ReadWriteLock {
	public void acquireRead()
			throws InterruptedException;
	public void releaseRead();
	public void acquireWrite()
			throws InterruptedException;
	public void releaseWrite();
}
