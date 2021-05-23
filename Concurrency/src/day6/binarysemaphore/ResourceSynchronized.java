package day6.binarysemaphore;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ResourceSynchronized implements ResourceType {

	public synchronized void access() {
		System.out.println("Thread " + Thread.currentThread().getName() + ": enter");
		try {
			TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(100));
		} catch (InterruptedException ex) {
		}
		System.out.println("Thread " + Thread.currentThread().getName() + ": exit");
	}
}