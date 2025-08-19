package multithreading.completablefuture;

import java.util.concurrent.*;

public class FutureAndCallableExample {

    public static void main(String[] args) {

        Callable<String> callable = ()->{
            TimeUnit.SECONDS.sleep(2);
            return "Hello";
        };
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(callable);
        try {
            String result = future.get();
            System.out.println("Result - "+result);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException Occurred...");
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            System.out.println("ExecutionException Occurred...");
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
