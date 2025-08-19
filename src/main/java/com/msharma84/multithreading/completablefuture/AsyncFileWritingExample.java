package multithreading.completablefuture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AsyncFileWritingExample {

    public static void main(String[] args) {

        List<String> dataToWrite = List.of("Line 1", "Line 2", "Line 3");

        CompletableFuture<Void> completableFuture = CompletableFuture
                .runAsync(() -> {
                        try{
                            writeFile("example.txt",dataToWrite);
                        }catch (IOException ioe){
                            System.out.println("Exception occurred..."+ioe.getMessage());
                        }
                });

        // Continue with other operations
        System.out.println("Main thread is free to run other tasks.");

        try {
            completableFuture.get(); // Blocks until the asynchronous file writing is complete
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(completableFuture.isDone()){
            System.out.println("Task Completed successfully...");
        }
    }

    private static void writeFile(String fileName, List<String> data) throws IOException {
        Path path = Path.of(fileName);
        Files.write(path, data, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
