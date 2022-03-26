/**
 * 
 */
package com.kenstar;

/**
 * @author mohit_sh
 *
 */
public class ThreadMainIntentionalException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Thread thread = new Thread(new Runnable() {

			public void run() {
				throw new RuntimeException("Intentional Exception");
			}
			
		});
		
		thread.setName("Misbehaving Thread");
		
		thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("A Critical error happened in thread : "+ t.getName() 
				+ " the error is : "+e.getMessage());
			}
		});
		
		thread.start();
	}

}
