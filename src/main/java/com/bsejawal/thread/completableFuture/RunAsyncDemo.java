package com.bsejawal.thread.completableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RunAsyncDemo {
    public static void main(String[] args) {
        System.out.println("RunAsyncDemo.main");
        RunAsyncDemo runAsyncDemo = new RunAsyncDemo();
        // Use ClassLoader to get the resource file from the classpath
        File jsonFile = new File(RunAsyncDemo.class.getClassLoader().getResource("employees.json").getFile());
        runAsyncDemo.saveEmployeeWithOldWay(jsonFile);
        runAsyncDemo.saveEmployeeWithCustomExecutor(jsonFile);
    }

    public Void saveEmployeeWithCustomExecutor(File jsonFile){
        ObjectMapper mapper = new ObjectMapper();
        Executor executor = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(
                () -> {
                try {
                    List<Employee> employees = mapper.readValue(jsonFile, new TypeReference<List<Employee>>() {
                    });
//                    you can write logic to save list of employee to database
                    System.out.println("lambda : "+Thread.currentThread().getName());

                    System.out.println(employees.size());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }, executor);
        try {
            return runAsyncFuture.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }


    public Void saveEmployeeWithOldWay(File jsonFile){
        ObjectMapper mapper = new ObjectMapper();
        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Employee> employees = mapper.readValue(jsonFile, new TypeReference<List<Employee>>() {
                    });
//                    you can write logic to save list of employee to database
                    System.out.println(Thread.currentThread().getName());

                    System.out.println(employees.size());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        try {
            return runAsyncFuture.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }

}
