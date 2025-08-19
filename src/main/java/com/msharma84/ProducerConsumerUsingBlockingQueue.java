package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingBlockingQueue {

    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);

        Thread producerThread = new Thread(() -> {
            for(int i =0; i <= 5 ; i++){
                System.out.println("Produced : "+i);
                try {
                    blockingQueue.put(i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumerThread = new Thread(()->{
            for(int i =0; i <= 5 ; i++){
                try {
                    int value =  blockingQueue.take();
                    System.out.println("Consumer : "+value);
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        producerThread.start();
        consumerThread.setPriority(10);
        consumerThread.start();
    }
}
