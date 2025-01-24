package multithreading.synchronization;

public class Counter {

	private int count = 0;
	
	public synchronized void increment() {
		System.out.println("Incremented by : "+Thread.currentThread().getName() + " value : "+count);
		count++;
	}
	
	public int getCount() {
		return count;
	}
}
