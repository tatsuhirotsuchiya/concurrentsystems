package day4;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Resource2 extends Resource {

	@Override
	public synchronized void access() {
		System.out.println("Thread " + Thread.currentThread().getName() + ": enter");
		try {
			TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(100));
		} catch (InterruptedException ex) {
		}
		System.out.println("Thread " + Thread.currentThread().getName() + ": exit");
	}
}