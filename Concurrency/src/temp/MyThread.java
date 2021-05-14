package temp;

public class MyThread implements Runnable {
	private String name;
	private Resource r1, r2;
	public MyThread(String name, Resource r1, Resource r2) {
		this.name = name; this.r1 = r1; this.r2 = r2;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
			eat();
		}
	}
	private void eat() {
		synchronized (r1) {
			System.out.println(name + ": get " + r1);
			synchronized (r2) {
				System.out.println(name + ": get " + r2);
				System.out.println("eating");
			}
			System.out.println(name + ": release " + r2);			
		}
		System.out.println(name + ": release " + r1);			
	}
}
