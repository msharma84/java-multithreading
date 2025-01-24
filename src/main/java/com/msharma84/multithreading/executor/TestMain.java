package multithreading.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i = 1; i<10; i++) {
			int finalI = i;
			executor.submit(()->{
					long result = factorial(finalI);
					System.out.println(result);
				}
			);
		}
		executor.shutdown();
	}
	
	private static long factorial(int n) {
		
		long fact = 1;
		for(int i = 1; i <=n; i++) {
			fact *= n;
		}
		return fact;
	}
}
