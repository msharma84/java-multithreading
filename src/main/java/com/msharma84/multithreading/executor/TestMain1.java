package multithreading.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestMain1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> future = executorService.submit(()-> 1+2);
		Integer result = future.get();
		System.out.println("Result : "+result);
		executorService.shutdown();
		System.out.println(executorService.isShutdown());
		System.out.println(executorService.isTerminated());
	}

}
