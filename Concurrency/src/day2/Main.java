package day2;

public class Main {
	public static void main(String[] args) {
		Resource r = new Resource();
		new UseResource(r, 0).start();
		new UseResource(r, 1).start();
	}
}
