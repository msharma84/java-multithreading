package multithreading.executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestMain2 {

	public static void main(String[] args){
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		Callable<Integer> call1 = ()->{
			System.out.println("Task-1");
			return 1;
		};
		
		Callable<Integer> call2 = ()->{
			System.out.println("Task-2");
			return 2;
		};
		
		Callable<Integer> call3= ()->{
			System.out.println("Task-3");
			return 3;
		};
		
		List<Callable<Integer>> callableList = Arrays.asList(call1,call2,call3);
		
		List<Future<Integer>> futures;
		try {
			futures = executorService.invokeAll(callableList);
			for(Future<Integer> f : futures) {
				System.out.println(f.get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}
}
