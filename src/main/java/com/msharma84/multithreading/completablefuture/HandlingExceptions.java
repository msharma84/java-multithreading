package multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;

public class HandlingExceptions {

    public static void main(String[] args) {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() ->{
            return  10 / 0 ;
        });

        future.exceptionally(
                ex ->{
                    System.out.println("Exception occurred : "+ex.getMessage());
                    return -1;
                }
        ).thenAccept(result ->{
            System.out.println("Result : "+result);
        });
    }
}
