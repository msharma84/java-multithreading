package multithreading.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class DependentService implements Runnable {
	
	private final CountDownLatch latch;
	
	public DependentService(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		
		try {
			Thread.sleep(3000);
			System.out.println("Hello World !!!");
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}finally {
			latch.countDown();
		}
	}
}
