package multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;

public class MultipleCompletableFuture {

    public static void main(String[] args) {

        CompletableFuture<String> future1 = CompletableFuture
                .supplyAsync( () ->  "Result 1");

        CompletableFuture<String> future2 = CompletableFuture
                .supplyAsync( () ->  "Result 2");

        CompletableFuture<String> future3 = CompletableFuture
                .supplyAsync( () ->  "Result 3");

        CompletableFuture<?> allFutures = CompletableFuture.allOf(future1,future2,future3);

        allFutures.thenRun( ()->{
            String result1 = future1.join();
            String result2 = future2.join();
            String result3 = future3.join();

            System.out.println(result1 + ","+ result2 + ","+ result3);
        });
    }
}
