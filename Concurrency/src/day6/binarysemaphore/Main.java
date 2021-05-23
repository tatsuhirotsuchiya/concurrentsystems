package day6.binarysemaphore;

public class Main {
	public static void main(String[] args) {
		ResourceType r = new ResourceFairSem();
		new UseResource(r, 0).start();
		new UseResource(r, 1).start();
	}
}
