package temp;

public class BankAccount {
	private int balance;
	private String name;
	
	public BankAccount(int balance, String name) {
		this.name = name;
		this.balance = balance;
	}
	public synchronized int get() {
		return balance;
	}
	public synchronized void deposit(int m) {
		balance += m;
	}
	public synchronized void withdraw(int m) {
		balance -= m;
	}
	public synchronized boolean checkAndWithdraw(int m) {
		if (balance >= m) {
			balance -= m;
			return true;
		} else {
			return false;
		}
	}
	public String getName() {
		return name;
	}
}	
