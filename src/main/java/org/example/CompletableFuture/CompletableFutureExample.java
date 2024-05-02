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

class ThenComposeAndThenComposeAsync{

    public static void main(String[] args){
        try{
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            // doing further computation by a thenCompose method
            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(()->{
                return "task completed";
            }, poolExecutor).thenCompose((String val)->{
                return CompletableFuture.supplyAsync(()-> val + " and");
            }).thenComposeAsync((String val) ->{
                return CompletableFuture.supplyAsync(()-> val + " finished");
            }); // the order remains intact in case of multiple async tasks

            System.out.println(asyncTask1.get());

            poolExecutor.shutdown();
        } catch (Exception e){

        }
    }
}

class ThenAcceptAndThenAcceptAsync{

    public static void main(String[] args){
        try{
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            CompletableFuture<Void> asyncTask1 = CompletableFuture.supplyAsync(()->{
                return "task completed";
            }, poolExecutor).thenAccept((String val)->{
                System.out.println("All done"); // used at the end of async task
            });

            poolExecutor.shutdown();
        } catch (Exception e){

        }
    }
}