package org.example.ExecutorUtilityExample;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

    public static void main(String[] args){
        ScheduledExecutorService poolObj = Executors.newScheduledThreadPool(5);

        Future<?> futureObj =  poolObj.scheduleWithFixedDelay(()->{
            System.out.println("hello");
        }, 5,3, TimeUnit.SECONDS); //will keep on printing hello in every 3 sec

        poolObj.shutdown();
    }
}
