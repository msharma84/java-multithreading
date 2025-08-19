package multithreading;

import java.util.concurrent.*;

public class MyTaskExecutorService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newSingleThreadExecutor();
        MyTask task = new MyTask();

        // Using Callable
        Future<String> future = service.submit((Callable<String>) task);
        System.out.println(future.get()); // Output: Result from Callable

        // Using Runnable
        service.submit((Runnable) task);
        service.shutdown();
    }
}
