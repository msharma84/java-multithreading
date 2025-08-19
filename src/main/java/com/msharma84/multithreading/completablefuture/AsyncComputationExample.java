package multithreading.completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class AsyncComputationExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Long> numList = LongStream.rangeClosed(1,1000000).boxed()
                .collect(Collectors.toList());

        CompletableFuture<Long> completableFuture = CompletableFuture
                .completedFuture(numList)
                .supplyAsync(() ->
                    numList.stream().mapToLong(Long::longValue).sum()
                );

        Long sum = completableFuture.get();
        System.out.println(sum);
    }
}
