package multithreading.completablefuture;

import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;

public class CombineCompletableFuture {

    public static void main(String[] args) {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Moto");

        CompletableFuture<String> combinedFuture = future1.thenCombine(future2,(result1,result2)-> result1+result2);

        /*
        CompletableFuture<String> combinedFuture = future1.thenCombine(future2,(result1,result2)-> {
            StringJoiner s = new StringJoiner(",");
            s.add(result1);
            s.add(result2);
            return s.toString();
        });
        */

        combinedFuture.thenAccept(System.out::println);
    }
}
