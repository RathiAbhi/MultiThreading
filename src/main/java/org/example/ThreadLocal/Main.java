package org.example.ThreadLocal;

public class Main {

    public static void main(String[] args){
        ThreadLocal<String> threadLocalObj = new ThreadLocal<>();
        threadLocalObj.set(Thread.currentThread().getName());

        Thread t1 = new Thread(()->{
            threadLocalObj.set(Thread.currentThread().getName());
            System.out.println(threadLocalObj.get());
        });

        t1.start();
        try{
            Thread.sleep(5000);
        } catch (Exception e){

        }
        System.out.println(threadLocalObj.get());
    }
}