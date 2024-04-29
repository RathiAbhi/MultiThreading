package org.example.practice;

public class Main {

    public static void main(String[] args){
        SharedResource resource = new SharedResource();
        System.out.println("Main Thread Started");

        Thread th1 = new Thread(() -> {
            System.out.println("Thread1 calling produce method");
            resource.produce();
        });

        th1.setDaemon(true); // only alive till any user thread is alive
        th1.start();

        System.out.println("Main thread finished");
    }
}
