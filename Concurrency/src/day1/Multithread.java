package day1;

public class Multithread {

	public static void main(String[] args) {
		new Thread(()-> {
			for(int i = 0; i < 1000; i++) {
				System.out.print("Nice!");
			}
		}).start();
		
		for (int i = 0; i < 1000; i++) {
			System.out.print("Good!");
		}

	}

}
