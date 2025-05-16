package com.bsejawal.thread.completableFuture;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SupplyAsyncDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SupplyAsyncDemo demo = new SupplyAsyncDemo();
        List<Employee> employees = demo.getEmployees();
        employees
                .forEach(System.out::println);

    }

    public List<Employee> getEmployees() throws ExecutionException, InterruptedException {
        Executor executor = Executors.newCachedThreadPool();
        CompletableFuture<List<Employee>> listCompletableFuture = CompletableFuture.supplyAsync(()-> {
            System.out.println("Executed By : " + Thread.currentThread().getName());
           return  EmployeeDatabase.fetchEmployees();
        },executor);
        return listCompletableFuture.get();
    }

}
