package org.example.ThreadPool;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args){

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new CustomRejectHandler());

        executor.allowCoreThreadTimeOut(true);

        for (int i=1; i<=7; i++){
            executor.submit(()->{
                try{
                    Thread.sleep(5000);
                }catch (Exception e){

                }
                System.out.println("Task processed by: "+Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}

class CustomThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        th.setDaemon(false);
        return th;
    }
}

class CustomRejectHandler implements RejectedExecutionHandler{
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected: "+r.toString());
    }
}
