package org.example.ExecutorUtilityExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        System.out.println("Main thread completed");
    }
}
