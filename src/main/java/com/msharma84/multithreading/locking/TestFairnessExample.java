package multithreading.locking;

public class TestFairnessExample {

	public static void main(String[] args) {
		
		FairnessExample fairness = new FairnessExample();
		Runnable task = () -> {
			fairness.accessResource();
		};
		
		Thread t1 = new Thread(task,"Task-1");
		Thread t2 = new Thread(task,"Task-2");
		Thread t3 = new Thread(task,"Task-3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
