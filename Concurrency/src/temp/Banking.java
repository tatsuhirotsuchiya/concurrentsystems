package temp;

public class Banking {

	public static void main(String[] args) throws InterruptedException {
		BankAccount a0 = new BankAccount(20, "Account 0");
		BankAccount a1 = new BankAccount(20, "Account 1");
		new Thread(new BankUserUnsafe(a0, a1)).start();
		new Thread(new BankUserUnsafe(a1, a0)).start();
//		new Thread(new BankUserUnsafe(a1, a0)).start();
	}
}
