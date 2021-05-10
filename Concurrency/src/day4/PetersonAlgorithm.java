package day4;

//Thread name must be "0" or "1"
public class PetersonAlgorithm implements MyLock {
	private volatile boolean[] want = new boolean[2];
	private volatile int last = 0;

	public void lock() {
		int i = Integer.parseInt(Thread.currentThread().getName());
		int j = 1 - i;
		want[i] = true;
		last = i;
		while (want[j] && last == i) {
		}
	}

	@Override
	public void unlock() {
		int i = Integer.parseInt(Thread.currentThread().getName());
		want[i] = false;
	}
}