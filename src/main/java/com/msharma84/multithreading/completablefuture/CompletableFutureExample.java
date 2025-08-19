package multithreading.completablefuture;

import java.util.concurrent.*;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Without using Executor Service thread pool mechanism
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->{
            try{
                System.out.println("Thread - "+Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException Occurred...");
                Thread.currentThread().interrupt();
            }
            return  "Hello World !";
        });

        String futureValue = future.get();
        System.out.println("Future Value - "+futureValue);

        // With using Executor Service thread pool mechanism
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() ->{
            try{
                System.out.println("Thread - "+Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException Occurred...");
                Thread.currentThread().interrupt();
            }
            return  "Hello World !";
        },executor);

        String futureValue1 = future1.get();
        System.out.println("Future Value - "+futureValue1);

        executor.shutdown();
    }
}
