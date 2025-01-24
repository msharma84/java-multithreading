package multithreading;

public class ThreadExample7 {

	public static void main(String[] args) {
		
		Runnable runnable = ()->{
			
			for(int i =0 ; i <5; i++) {
				System.out.println("Running");
				sleep(1000);
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.setDaemon(true);
		thread.start();
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
