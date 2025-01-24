package multithreading;

public class ThreadExample5 {
	
	public static void main(String [] args) {
		
		Runnable runnable = ()->{
			String threadName = Thread.currentThread().getName();
			System.out.println("Current Thread Name : "+threadName);
		};
		
		Thread thread1 = new Thread(runnable,"Task-1");
		thread1.start();
		
		Thread thread2 = new Thread(runnable,"Task-2");
		thread2.start();
	}

}
