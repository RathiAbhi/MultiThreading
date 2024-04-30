package org.example.ReadWriteLock;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {
    boolean isAvailable = false;
    public void producer(ReadWriteLock lock){
        try {
            lock.readLock().lock();
            System.out.println("Read Lock acquired by: "+ Thread.currentThread().getName());
            Thread.sleep(8000);
        } catch (Exception e){

        }
        finally {
            lock.readLock().unlock();
            System.out.println("Read lock released by: "+ Thread.currentThread().getName());
        }
    }

    public void consume(ReadWriteLock lock){
        try {
            lock.writeLock().lock();
            System.out.println("Write lock acquired by: "+Thread.currentThread().getName());
            isAvailable = false;
        } catch (Exception e){

        }
        finally {
            lock.writeLock().unlock();
            System.out.println("Write lock released by: "+Thread.currentThread().getName());
        }
    }
}
