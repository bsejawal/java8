package com.bsejawal.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutorServiceWithReturn {
    public static void main(String[] args) {

        //create the pool
        ExecutorService service = Executors.newFixedThreadPool(10);
        //submit the tasks for execution
        List<Future> allFutures = new ArrayList<>();
        for(int i=0; i<100; i++){
           Future<Integer> future  = service.submit(new Task());
           allFutures.add(future);
        }
        for(int i=0; i<100; i++) {
            Future<Integer> future = allFutures.get(i);
            try {
                Integer result = future.get();
                System.out.println("result at "+i+" is "+ result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
service.shutdown();
    }
    static class Task implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            return new Random().nextInt();
        }
    }
}
