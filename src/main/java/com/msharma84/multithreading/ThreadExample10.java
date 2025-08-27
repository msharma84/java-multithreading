package multithreading;

public class ThreadExample10 {

    public static void main(String[] args) {

        Runnable runnable = () -> {
                throw new RuntimeException("Purposely thrown");
        };

        Thread thread = new Thread(runnable,"Task-0");
        thread.setUncaughtExceptionHandler((t, e) -> System.out.println("A critical exception occurred on..."+t.getName()
                + ", Message : "+e.getMessage()));
        thread.start();
    }
}
