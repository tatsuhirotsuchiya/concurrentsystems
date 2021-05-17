package day5;

public class BankUserUnsafe implements Runnable {
	BankAccount a1, a2;

	BankUserUnsafe(BankAccount a1, BankAccount a2) {
		this.a1 = a1;
		this.a2 = a2;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (a1.get() >= 10) {
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				a1.withdraw(10);
				a2.deposit(10);
			}
			System.out.println(a1.get() + "," + a2.get());
		}
	}
}
