package day2;

// Thread name must be "0" or "1"
public class LockAttempt1 implements MyLock {
	private volatile int turn = 0;
	
	@Override
	public void lock() {
		int id = Integer.parseInt(Thread.currentThread().getName());
		while (turn != id) {}
	}

	@Override
	public void unlock() {
		int id = Integer.parseInt(Thread.currentThread().getName());
		turn = 1 - id;
	}
}
