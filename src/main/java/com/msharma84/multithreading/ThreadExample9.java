package multithreading;

public class ThreadExample9 {

	public static void main(String[] args) {

		Runnable runnable = ()-> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "Priority : "+Thread.currentThread().getPriority() );
		};
		
		Thread h = new Thread(runnable,"High Priority Thread");
		Thread m = new Thread(runnable,"Medium Priority Thread");
		Thread l = new Thread(runnable,"Low Priority Thread");
		
		h.setPriority(Thread.MAX_PRIORITY);
		m.setPriority(Thread.NORM_PRIORITY);
		l.setPriority(Thread.MIN_PRIORITY);
		
		h.start();
		m.start();
		l.start();
	}
}
