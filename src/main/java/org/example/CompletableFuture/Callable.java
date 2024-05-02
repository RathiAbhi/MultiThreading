package org.example.CompletableFuture;

import java.util.concurrent.*;

public class Callable {

    public static void main(String[] args){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // callable interface is used when we want an output from a thread
        // hence it returns some value and our future variable can store that

        Future<Integer> futureObj = threadPoolExecutor.submit(()->{
            return 3;
        });

        try {
            System.out.println(futureObj.get());
        } catch (Exception e){

        }
        threadPoolExecutor.shutdown();
    }
}
