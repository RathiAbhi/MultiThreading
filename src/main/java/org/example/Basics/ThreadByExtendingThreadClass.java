package org.example.Basics;

public class ThreadByExtendingThreadClass extends Thread{
    @Override
    public void run(){
        System.out.println("code executed by thread: "+ Thread.currentThread().getName());
    }

    public static void main(String[] args){
        System.out.println("Going inside main: "+ Thread.currentThread().getName());
        ThreadByExtendingThreadClass myThread = new ThreadByExtendingThreadClass();
        myThread.start();
        System.out.println("Finishing the main: "+ Thread.currentThread().getName());
    }
}
