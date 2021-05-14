package temp;

public class TwoPhils {

	public static void main(String[] args) {
		Resource res0 = new Resource("Fork 0");
		Resource res1 = new Resource("Fork 1");
		new Thread(new MyThread("Thread1", res0, res1)).start();
		new Thread(new MyThread("Thread2", res1, res0)).start();
	}
}