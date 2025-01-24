package multithreading;

public class ThreadSleep {
	
	public static void main(String [] args) {
		
		Runnable runnable = ()-> {
			
			String threadName = Thread.currentThread().getName();
			System.out.println("Current Running thread : "+threadName);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Thread terminated : "+threadName);
		};
		
		Thread thread1 = new Thread(runnable,"Task-1");
		thread1.start();
		
		Thread thread2 = new Thread(runnable,"Task-2");
		thread2.start();
		
		Thread thread3 = new Thread(runnable,"Task-3");
		thread3.start();
		
		Thread thread4 = new Thread(runnable,"Task-4");
		thread4.start();
		
		Thread thread5 = new Thread(runnable,"Task-5");
		thread5.start();
	}
}
