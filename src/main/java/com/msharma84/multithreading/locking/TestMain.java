package multithreading.locking;

public class TestMain {

	public static void main(String[] args) {
		
		BankAccount bankAccount = new BankAccount();
		Runnable runnable = ()->{
			bankAccount.withdraw(50);
		};
		
		Thread t1 = new Thread(runnable,"Task-1");
		Thread t2 = new Thread(runnable,"Task-2");
		
		t1.start();
		t2.start();
	}
}
