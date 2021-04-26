package day3;

public class UseResource extends Thread {
	private final Resource r;
	
	UseResource(Resource r, int id) {
		super(Integer.toString(id));
		this.r = r;
	}
	
	public void run() {
		while (true) {
			r.access();
		}
	}
}
