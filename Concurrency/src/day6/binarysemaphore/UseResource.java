package day6.binarysemaphore;

public class UseResource extends Thread {
	private final ResourceType r;
	
	UseResource(ResourceType r, int id) {
		super(Integer.toString(id));
		this.r = r;
	}
	
	public void run() {
		while (true) {
			r.access();
		}
	}
}
