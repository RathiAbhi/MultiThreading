package org.example.Basics;

public class ThreadByImplementingRunnableInterface implements Runnable {

    @Override
    public void run(){
        System.out.println("code executed by thread: "+ Thread.currentThread().getName());
    }

    public static void main(String[] args){
        System.out.println("Going inside main: "+ Thread.currentThread().getName());
        ThreadByImplementingRunnableInterface runnableObj = new ThreadByImplementingRunnableInterface();
        Thread thread = new Thread(runnableObj);
        thread.start();
        System.out.println("Finishing the main: "+ Thread.currentThread().getName());
    }
}
