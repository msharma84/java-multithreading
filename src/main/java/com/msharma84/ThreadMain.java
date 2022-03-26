/**
 * 
 */
package com.kenstar;

/**
 * @author mohit_sh
 *
 */
public class ThreadMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Thread thread = new Thread(new Runnable() {
			@Override
		    public void run() {
		    	System.out.println("Starting a new Thread..."+Thread.currentThread().getName());
		    }
		});
		
		thread.setName("New Worker Thread...");
		
		System.out.println("We are in thread..."+Thread.currentThread().getName() + " before starting a new Thread");
		thread.start();
		System.out.println("We are in thread..."+Thread.currentThread().getName() + " after starting a new Thread");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
