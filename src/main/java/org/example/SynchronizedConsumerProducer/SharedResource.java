package org.example.SynchronizedConsumerProducer;

public class SharedResource {
    boolean isItemPresent = false;

    public synchronized void addItem(){
        isItemPresent = true;
        System.out.println("Producer thread calling the notify method");
        notifyAll();
    }

    public synchronized void consumeItem(){

        System.out.println("Consumer thread inside consumeItem method");
        if (!isItemPresent){
            try {
                System.out.println("Consumer thread is waiting");
                wait();
            } catch (Exception e){

            }
        }
        System.out.println("Consumer thread consumed the item");
        isItemPresent = false;
    }
}
