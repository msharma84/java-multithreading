package multithreading;

public class ThreadExample11 {

	public static void main(String[] args) {
		
		Runnable runnable = ()-> {
			for(int i =0 ; i< 5; i++) {
				System.out.println(Thread.currentThread().getName() + " is running");
				Thread.yield();
			}
		};
		
		Thread t1 = new Thread(runnable,"Task-1");
		Thread t2 = new Thread(runnable,"Task-2");
		
		t1.start();
		t2.start();
	}
}
