package multithreading;

public class ThreadExample4 {
	
	public static void main(String []args) {
		
		Runnable runnable = ()->{
			System.out.println("Runnable is running");
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
	}

}
