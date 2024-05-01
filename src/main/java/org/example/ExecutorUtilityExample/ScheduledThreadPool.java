package org.example.ExecutorUtilityExample;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

    public static void main(String[] args){
        ScheduledExecutorService poolObj = Executors.newScheduledThreadPool(5);

        Future<String> futureObj =  poolObj.schedule(()->{
            return "hello";
        }, 5, TimeUnit.SECONDS);

        try {
            System.out.println(futureObj.get());
        } catch (Exception e){

        }
        poolObj.shutdown();
    }
}
