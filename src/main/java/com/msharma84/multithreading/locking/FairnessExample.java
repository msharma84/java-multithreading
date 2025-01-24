package multithreading.locking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessExample {

	private final Lock lock = new ReentrantLock(true);
	
	public void accessResource() {
		
		lock.lock();
		
		try {
			System.out.println(Thread.currentThread().getName() + " acquired the lock");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			System.out.println(Thread.currentThread().getName()+ " release the lock");
			lock.unlock();
		}
	}
}
