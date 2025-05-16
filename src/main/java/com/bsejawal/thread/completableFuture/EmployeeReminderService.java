package com.bsejawal.thread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class EmployeeReminderService {
    public static void main(String[] args) {
        EmployeeReminderService employeeReminderService = new EmployeeReminderService();
//        employeeReminderService.sendReminderToEmployee();
        System.out.println("sendReminderToEmployeeAsync##");
        employeeReminderService.sendReminderToEmployeeAsync();
    }

    public void sendReminderToEmployee() {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    System.out.println("FetchEmployee : " + Thread.currentThread().getName());
                    return EmployeeDatabase.fetchEmployees();
                })
                .thenApply((employees) -> {
                    System.out.println("filter new Joiner employees: " + Thread.currentThread().getName());
                    return employees.stream()
                            .filter((employee) -> "TRUE".equals(employee.newJoiner()))
                            .collect(Collectors.toList());
                })
                .thenApply(employees -> {
                    System.out.println("filter training not completed employees: " + Thread.currentThread().getName());
                    return employees.stream()
                            .filter(employee -> "TRUE".equals(employee.learningPending()))
                            .collect(Collectors.toList());
                })
                .thenApply(employees -> {
                    System.out.println("get Emails : " + Thread.currentThread().getName());
                    return employees.stream().map(Employee::email)
                            .collect(Collectors.toList());
                })
                .thenAccept(emails -> {
                    emails.forEach(EmployeeReminderService::sendEmail);

                });
        voidCompletableFuture.join();
    }

    public void sendReminderToEmployeeAsync() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    System.out.println("FetchEmployee : " + Thread.currentThread().getName());
                    return EmployeeDatabase.fetchEmployees();
                }, executor)
                .thenApplyAsync((employees) -> {
                    System.out.println("filter new Joiner employees: " + Thread.currentThread().getName());
                    return employees.stream()
                            .filter((employee) -> "TRUE".equals(employee.newJoiner()))
                            .collect(Collectors.toList());
                })
                .thenApplyAsync(employees -> {
                    System.out.println("filter training not completed employees: " + Thread.currentThread().getName());
                    return employees.stream()
                            .filter(employee -> "TRUE".equals(employee.learningPending()))
                            .collect(Collectors.toList());
                }, executor)
                .thenApplyAsync(employees -> {
                    System.out.println("get Emails : " + Thread.currentThread().getName());
                    return employees.stream().map(Employee::email)
                            .collect(Collectors.toList());
                },executor)
                .thenAcceptAsync(emails -> {
                    emails.forEach(EmployeeReminderService::sendEmail);

                }, executor);
        voidCompletableFuture.join();
        executor.shutdown();

    }


    public static void sendEmail(String email){
//        System.out.println("sending training reminder email to: "+ email);

    }

}
