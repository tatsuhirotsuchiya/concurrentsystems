package day5;

public class BankUserSafe implements Runnable {
	BankAccount a1, a2;

	BankUserSafe(BankAccount a1, BankAccount a2) {
		this.a1 = a1;
		this.a2 = a2;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			if (a1.checkAndWithdraw(10)) {
				a2.deposit(10);
			}
			System.out.println(a1.get() + "," + a2.get());
		}
	}
}
