package multithreading;

public class ThreadExample2 {
	
	public static class MyRunnable implements Runnable{

		public void run() {
			System.out.println("MyRunnable is runnig");
		}
	}
	
	public static void main(String args []) {
		
		Thread thread = new Thread(new MyRunnable());
		thread.start();
	}
}
