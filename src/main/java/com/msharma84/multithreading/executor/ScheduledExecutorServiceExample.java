package multithreading.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {

	public static void main(String[] args) {
		
		ScheduledExecutorService schExecutorService = Executors.newScheduledThreadPool(1);
		
		Runnable task = () ->{
			System.out.println("Hello World !!!");
		};
		
		//schExecutorService.schedule(task, 10, TimeUnit.SECONDS);
		
		schExecutorService.scheduleAtFixedRate(task, 5, 5, TimeUnit.SECONDS);
		
		schExecutorService.schedule(()->schExecutorService.shutdown(), 20, TimeUnit.SECONDS);
		
		//schExecutorService.shutdown();
	}

}
