package multithreading;

public class ThreadExample1 {

	public static class MyThread extends Thread {

		@Override
		public void run() {
			System.out.println("MyThread is running");
		}
	}
	
	public static void main(String[] args) {
		
		MyThread mythread = new MyThread();
		mythread.start();
		
	}

}
