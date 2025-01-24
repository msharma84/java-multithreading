package multithreading.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample {

	public static void main(String[] args) {
		
		int numOfService = 3;
		
		ExecutorService executor = Executors.newFixedThreadPool(numOfService);
		CountDownLatch latch = new CountDownLatch(numOfService);
		executor.submit(new DependentService(latch));
		executor.submit(new DependentService(latch));
		executor.submit(new DependentService(latch));
		
		try {
			//latch.await();
			latch.await(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("Main");
		executor.shutdown();
	}
}
