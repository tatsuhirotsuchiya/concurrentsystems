package day3;

// Thread name must be "0" or "1"
public class LockAttempt2 implements MyLock {
	private volatile boolean[] want = new boolean[2];
	
	@Override
	public void lock() {
		int id = Integer.parseInt(Thread.currentThread().getName());
		while (want[1 - id] == true) {}
		want[id] = true;
	}

	@Override
	public void unlock() {
		int id = Integer.parseInt(Thread.currentThread().getName());
		want[id] = false;
	}
}
