package day4;

import java.util.concurrent.TimeUnit;

public class StopThread {
	volatile static boolean stopRequested;
	
	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(new BackgroundThread());
		backgroundThread.start();

		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
	}
}

class BackgroundThread implements Runnable {
	@Override
	public void run() {
		int i = 0;
		while (!StopThread.stopRequested)
			i++;
		System.out.println(i);	
	}
}