package com.bsejawal.java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThread {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task());
        thread1.start();
        System.out.println("Thread Name : "+ Thread.currentThread().getName());

        for(int i=0;i<10; i++){
            Thread thread2 = new Thread(new Task());
            thread2.start();
        }


        //With ExecutorService
//create the pool
        ExecutorService service = Executors.newFixedThreadPool(10);
        //submit the task for execution
        for(int i=0;i<10; i++){
            service.execute(new Task());
        }
        System.out.println("Thread Name : "+ Thread.currentThread().getName());
service.shutdown();

    }
    static class Task implements Runnable{
        public void run(){
            System.out.println("Thread name : "+ Thread.currentThread().getName());
        }
    }
}
