package org.example.CompletableFuture;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args){

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS,new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // future variable maintains the status of a thread whether completed or not
        Future<?> futureObj = poolExecutor.submit(()->{
            System.out.println("Task by thread");
        });

        System.out.println("is done: "+ futureObj.isDone());
        poolExecutor.shutdown();
    }
}
