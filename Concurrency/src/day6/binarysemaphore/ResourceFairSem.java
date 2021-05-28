package day6.binarysemaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ResourceFairSem implements ResourceType {

	final Semaphore sem = new Semaphore(1, false);
	
	public void access() {
		try {
			sem.acquire();
		}
		catch (InterruptedException e) {return; }
		System.out.println("Thread " + Thread.currentThread().getName() + ": enter");
		try {
			TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(100));
		} catch (InterruptedException ex) {}
		System.out.println("Thread " + Thread.currentThread().getName() + ": exit");
		sem.release();
	}
}