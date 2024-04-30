package org.example.Condition;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void producer(){
        try {
            lock.lock();
            System.out.println("Producer lock acquired by: "+Thread.currentThread().getName());
            if (isAvailable){
                // already available, thread has to wait for it to consume
                System.out.println("Producer thread is waiting: "+ Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = true;
            condition.signal();
        } catch (Exception e){

        }
        finally {
            lock.unlock();
            System.out.println("Producer lock released by: "+Thread.currentThread().getName());
        }
    }

    public void consumer(){
        try {
            Thread.sleep(1000);
            lock.lock();
            System.out.println("Consumer lock acquired by: "+Thread.currentThread().getName());

            if (!isAvailable){
                // not available, thread has to wait for it to get produced
                System.out.println("Consumer thread is waiting: "+Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = false;
            condition.signal();
        } catch (Exception e){

        }
        finally {
            lock.unlock();
            System.out.println("Consumer lock released by: "+Thread.currentThread().getName());
        }
    }
}
