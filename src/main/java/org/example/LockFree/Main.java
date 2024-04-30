package org.example.LockFree;

public class Main {
    public static void main(String[] args){
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(()-> {
            for (int i=0; i<200; i++){
                resource.increment();
            }
        });

        Thread t2 = new Thread(()-> {
            for (int i=0; i<200; i++){
                resource.increment();
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (Exception e){

        }

        System.out.println(resource.get());
    }
}
