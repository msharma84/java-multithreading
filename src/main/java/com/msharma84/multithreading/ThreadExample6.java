package multithreading;

public class ThreadExample6 {
	
	public static class StopabbleRunnable implements Runnable{

		private boolean stopRequested = false;
		
		public synchronized void requestStop() {
			this.stopRequested = true;
		}
		
		public synchronized boolean isStopRequested() {
			return this.stopRequested;
		}
		
		private void sleep(long millis) {
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			
			String threadName = Thread.currentThread().getName();
			System.out.println("Current Thread : "+threadName + " is running");
			
			while(! isStopRequested()) {
				sleep(1000);
				System.out.println(threadName + "...");
			}
			System.out.println("Thread stopped : "+threadName);
		}
	}
	
	public static void main(String [] args) {
		
		StopabbleRunnable stoppableRunnable = new StopabbleRunnable();
		
		Thread thread1 = new Thread(stoppableRunnable,"Task-1");
		thread1.start();
		
		Thread thread2 = new Thread(stoppableRunnable,"Task-2");
		thread2.start();
		
		try {
			thread1.sleep(5000);
			thread2.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Stopping thread :");
		stoppableRunnable.requestStop();
		
	}

}
