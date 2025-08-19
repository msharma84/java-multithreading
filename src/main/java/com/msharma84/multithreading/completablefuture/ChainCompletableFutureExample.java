package multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;

public class ChainCompletableFutureExample {

    public static void main(String[] args) {

        // Chained multiple asynchronous operation together
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->10)
                .thenApplyAsync(result -> result * 2)
                .thenApplyAsync(result -> result + 5);

        future.thenAccept(result -> System.out.println(result));
    }
}
