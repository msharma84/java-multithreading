package multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EvenAndOddNumbers {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        IntStream.rangeClosed(1,100).forEach(
                num -> {
                    CompletableFuture<Integer> odd = CompletableFuture.completedFuture(num).thenApplyAsync(
                            x -> {
                                if(x % 2 !=0){
                                    System.out.println("Thread Name " + Thread.currentThread().getName() + " value : "+x);
                                }
                                return num;
                            },executorService
                    );
                    odd.join();

                    CompletableFuture<Integer> even = CompletableFuture.completedFuture(num).thenApplyAsync(
                            x -> {
                                if(x % 2 ==0){
                                    System.out.println("Thread Name " + Thread.currentThread().getName() + " value : "+x);
                                }
                                return num;
                            },executorService
                    );
                    even.join();
                }
        );
        executorService.shutdown();
    }
}
