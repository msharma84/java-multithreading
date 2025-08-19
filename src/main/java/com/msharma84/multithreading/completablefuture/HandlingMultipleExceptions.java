package multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;

public class HandlingMultipleExceptions {

    public static void main(String[] args) {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(()-> {return 1;});

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(()-> {return 10/0 ;});

        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(()-> {return 10/2;});

        CompletableFuture<?> allFutures = CompletableFuture.allOf(future1,future2,future3);

        allFutures.exceptionally(ex -> {
            System.out.println("Exception occurred: " + ex.getMessage());
            return null; // Default value to return if there's an exception
        }).thenRun(() -> {
            // All futures completed
            int result1 = future1.join();
            int result2 = future2.join();
            int result3 = future3.join();
            System.out.println(result1 + ", " + result2 + ", " + result3);
        });
    }
}
