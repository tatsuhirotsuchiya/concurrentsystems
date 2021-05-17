package day5;

public class Banking {

	public static void main(String[] args) {
		BankAccount a0 = new BankAccount(10, "Account 0");
		BankAccount a1 = new BankAccount(10, "Account 1");
		new Thread(new BankUserSafe2(a0, a1)).start();
		new Thread(new BankUserSafe2(a1, a0)).start();
//		new Thread(new BankUserSafe2(a1, a0)).start();
	}
}
