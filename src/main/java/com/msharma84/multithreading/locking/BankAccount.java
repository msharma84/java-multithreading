package multithreading.locking;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
	
	private int balance = 100;
	
	private final Lock lock = new ReentrantLock();
	
	public void withdraw(int amount) {
		
		System.out.println(Thread.currentThread().getName()+" attempting to withdraw "+amount);
		
		try {
			if(lock.tryLock(1000,TimeUnit.MILLISECONDS)) {
				if(balance >= amount) {
					System.out.println(Thread.currentThread().getName() + " proceeding to withdrawal");
					try {
						Thread.sleep(3000);
						balance -= amount;
						System.out.println(Thread.currentThread().getName() + " withdrawal completed, remaining balance: "+balance);
					} catch (Exception e) {
						Thread.currentThread().interrupt();
					}finally {
						lock.unlock();
					}
				}else {
					System.out.println("Insufficient balance...");
				}
			}else {
				System.out.println("could not acquire the lock try again...");
			}
		} catch (InterruptedException e1) {
			Thread.currentThread().interrupt();
		}
	}
	
	public int getBalance() {
		return this.balance;
	}
}
