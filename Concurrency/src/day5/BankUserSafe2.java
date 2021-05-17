package day5;

public class BankUserSafe2 implements Runnable {
	BankAccount a1, a2;

	BankUserSafe2(BankAccount a1, BankAccount a2) {
		this.a1 = a1;
		this.a2 = a2;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			synchronized (a1) {	
				synchronized (a2) {
					if (a1.get() >= 10) {
						a1.withdraw(10);
						a2.deposit(10);
					}
				}
			}
			System.out.println(a1.get() + "," + a2.get());
		}
	}
}
