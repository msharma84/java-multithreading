package multithreading;

public class ThreadExample10 {

	public static void main(String[] args) {
		
		Runnable runnable = ()->{
			
			try {
				Thread.sleep(5000);
				System.out.println("Thread is running");
			} catch (InterruptedException e) {
				System.out.println("Exception : "+e);
			}
		};
		
		Thread t = new Thread(runnable);
		t.start();
		t.interrupt();
	}

}
