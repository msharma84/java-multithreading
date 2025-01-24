package multithreading;

public class ThreadExample8 extends Thread {
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String [] args) throws InterruptedException {
		
		ThreadExample8 t1 = new ThreadExample8();
		System.out.println(t1.getState());
		t1.start();
		System.out.println(t1.getState());
		Thread.sleep(1000);
		System.out.println(t1.getState());
		t1.join();
		System.out.println(t1.getState());
	}
}
