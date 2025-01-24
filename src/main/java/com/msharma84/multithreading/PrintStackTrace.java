package multithreading;

public class PrintStackTrace {

	public static void main(String[] args) {
		
		StackTraceElement [] stackTrace = Thread.currentThread().getStackTrace();
		for(int i=0; i< stackTrace.length; i++) {
			System.out.println(stackTrace[i].getClassName());
		}
	}

}
