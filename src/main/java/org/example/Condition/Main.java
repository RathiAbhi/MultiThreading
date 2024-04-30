package org.example.Condition;

public class Main {
    public static void main(String[] args){
        SharedResource resource = new SharedResource();
        Thread th1 = new Thread(()-> {
            for (int i=0; i<2; i++){
                resource.producer();
            }
        });

        Thread th2 = new Thread(()-> {
            for (int i=0; i<2; i++){
                resource.consumer();
            }
        });

        th1.start();
        th2.start();
    }
}