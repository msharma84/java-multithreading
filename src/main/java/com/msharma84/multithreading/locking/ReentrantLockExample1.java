package multithreading.locking;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample1 {
	
	private static final ReentrantLock reentrantLock = new ReentrantLock();
	
	public static void main(String[] args) {
			
		Runnable task1 = () ->{
			if(reentrantLock.tryLock()) {
				try {
					System.out.println("Thread 1 acquired the lock");
				}finally {
					reentrantLock.unlock();
					System.out.println("Thread 1 released the lock");
				}
			}else {
				System.out.println("Thread 1 couldn't acquire the lock");
			}
		};
		
		Runnable task2 = () ->{
			if(reentrantLock.tryLock()) {
				try {
					System.out.println("Thread 2 acquired the lock");
				}finally {
					reentrantLock.unlock();
					System.out.println("Thread 2 released the lock");
				}
			}else {
				System.out.println("Thread 2 couldn't acquire the lock");
			}
		};
		
		Thread t2 = new Thread(task2);
		Thread t1 = new Thread(task1);
		
		
		t1.start();
		t2.start();
	}
}
