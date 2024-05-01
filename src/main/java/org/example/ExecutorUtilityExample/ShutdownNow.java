package org.example.ExecutorUtilityExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShutdownNow {

    public static void main(String[] args){
        ExecutorService poolObj = Executors.newFixedThreadPool(5);

        poolObj.submit(()-> {
            try {
                Thread.sleep(15000);
            } catch (Exception e){

            }
            System.out.println("Task completed");
        });
        poolObj.shutdownNow(); // will interrupt and stop the above active thread

        System.out.println("Main thread completed");
    }
}
