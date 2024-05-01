package org.example.ExecutorUtilityExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args){
        ExecutorService poolObj =  Executors.newFixedThreadPool(5);

        poolObj.submit(()->{
            try {
                Thread.sleep(5000);
            } catch (Exception e){

            }
            System.out.println("Task completed");
        });
        poolObj.shutdown();
        try {
            boolean isTerminated = poolObj.awaitTermination(2, TimeUnit.SECONDS);
            System.out.println("is terminated: "+isTerminated);
        } catch (Exception e){

        }
        System.out.println("Main thread completed");
    }
}
