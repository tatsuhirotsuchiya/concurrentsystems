package day4;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Resource {
	private MyLock mutex = new PetersonAlgorithm();
	
	public void access() {
		mutex.lock();
		System.out.println
		("Thread " + Thread.currentThread().getName() + ": enter");
		try {
			TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
		}
		catch (InterruptedException ex) {}
		System.out.println
		("Thread " + Thread.currentThread().getName() + ": exit");
		mutex.unlock();
	}
}
