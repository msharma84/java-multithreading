package multithreading;

public class ThreadExample3 {
	
	public static void main(String [] args) {
		
		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println("Runnable is running");
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
