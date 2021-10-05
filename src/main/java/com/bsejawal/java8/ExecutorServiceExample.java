package com.bsejawal.java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("ExecutorService");
//            }
//        });
//        executorService.shutdown();

        //example2
        //get count of all available cores
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        //submit the tasks for execution
        for(int i=0; i<100; i++){
            service.execute(new CpuIntensiveTask());
        }

        service.shutdown();
    }

    static class CpuIntensiveTask implements Runnable{
        public void run(){
            //some CPU intensive operations
        }
    }

}
