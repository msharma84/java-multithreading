package multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    private int capacity;
    private Queue<Integer> queue = new LinkedList<>();

    public ProducerConsumer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int value) throws InterruptedException {
        while(queue.size()==capacity){
            wait();
        }
        queue.add(value);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while(queue.isEmpty()){
                wait();
        }
        Integer i = queue.poll();
        notifyAll();
        return i;
    }

    public static void main(String[] args) {

        ProducerConsumer producerConsumer = new ProducerConsumer(5);
        Thread producerThread = new Thread(() -> {
            for(int i =0; i <= 5 ; i++){
                System.out.println("Produced : "+i);
                try {
                    producerConsumer.produce(i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumerThread = new Thread(()->{
            for(int i =0; i <= 5 ; i++){
                try {
                    int value =  producerConsumer.consume();
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
