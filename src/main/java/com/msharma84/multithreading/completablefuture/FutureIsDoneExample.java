package multithreading.completablefuture;

import java.util.concurrent.*;

public class FutureIsDoneExample {

    public static void main(String[] args) {

        Callable<String> callable = () ->{
            TimeUnit.SECONDS.sleep(2);
          return "Hello";
        };

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future =  executorService.submit(callable);
        while (!future.isDone()){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException occurred !!!");
                Thread.currentThread().interrupt();
            }
            System.out.println("Still Processing !!!");
        }
        try {
            String result = future.get();
            System.out.println("Result - "+result);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException occurred !!!");
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            System.out.println("ExecutionException occurred !!!");
        }
        executorService.shutdown();
    }
}
