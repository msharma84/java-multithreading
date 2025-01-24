package multithreading.locking;

public class ReadWriteLockExample {

	public static void main(String[] args) {
		
		ReadWriteCounter counter = new ReadWriteCounter();
		
		Runnable writeTask = () -> {
			
			for(int i =0 ; i<10; i++) {
				System.out.println("Increment By: "+Thread.currentThread().getName());
				counter.increment();
			}
		};
		
		Runnable readTask = () ->{
			
			for(int i =0; i<10; i++) {
				System.out.println("Read By: "+Thread.currentThread().getName() + " count value "+counter.getCount()); 
			}
		};
		
		Thread writingOperation = new Thread(writeTask,"Write-Thread-1");
		Thread readOperation1 = new Thread(readTask,"Read-Thread-1");
		Thread readOperation2 = new Thread(readTask,"Read-Thread-2");
		
		writingOperation.start();
		readOperation1.start();
		readOperation2.start();
		
		try {
			writingOperation.join();
			readOperation1.join();
			readOperation2.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("Final count value : "+counter.getCount());
	}
}
