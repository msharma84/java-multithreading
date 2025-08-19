package multithreading;

import java.util.concurrent.Callable;

public class MyTask implements Runnable, Callable<String> {

    @Override
    public void run() {
        System.out.println("Running via Runnable");
    }

    @Override
    public String call() throws Exception {
        return "Result from Callable";
    }
}
