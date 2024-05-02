package org.example.CompletableFuture;

import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args){
        try{
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            // passing an executor to hold more control over the async tasks
            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(()->{
                return "task completed";
            }, poolExecutor);

            System.out.println(asyncTask1.get());

            poolExecutor.shutdown();
        } catch (Exception e){

        }
    }
}

class ThenApply{
    public static void main(String[] args){
        try{
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            // doing further computation by a thenapply method
            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(()->{
                System.out.println("Thread: "+Thread.currentThread().getName());
                return "task completed";
            }, poolExecutor).thenApply((String val)->{
                System.out.println("Thread: "+Thread.currentThread().getName()); //same thread
                return val + " and executed";
            });

            System.out.println(asyncTask1.get());

            poolExecutor.shutdown();
        } catch (Exception e){

        }
    }
}

class ThenApplyAsync{
    public static void main(String[] args){
        try{
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            // doing further computation by a thenapplyAsync method
            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(()->{
                System.out.println("Thread: "+Thread.currentThread().getName());
                return "task completed";
            }, poolExecutor).thenApplyAsync((String val)->{
                System.out.println("Thread: "+Thread.currentThread().getName()); //different thread
                return val + " and executed";
            });

            System.out.println(asyncTask1.get());

            poolExecutor.shutdown();
        } catch (Exception e){

        }
    }
}