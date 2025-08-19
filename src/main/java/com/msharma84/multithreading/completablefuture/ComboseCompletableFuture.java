package multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;

public class ComboseCompletableFuture {

    public static void main(String[] args) {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> future2 =  future1
                .thenCompose(result ->
                        CompletableFuture.supplyAsync(
                                () -> result.toUpperCase()));

        future2.thenAccept(System.out::println);
    }
}
