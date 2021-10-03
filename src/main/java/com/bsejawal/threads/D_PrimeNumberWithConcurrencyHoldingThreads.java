package com.bsejawal.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D_PrimeNumberWithConcurrencyHoldingThreads {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        Runnable statusReporter = () ->{
            while(true) {
                try {
                    Thread.sleep(5000);
                    printThreads(threads);
                } catch (InterruptedException e) {
                    System.out.println("Status report thread interrupted. Ending status updates...");
                }
            }
        };
        Thread reporterThread = new Thread(statusReporter);
        reporterThread.setDaemon(true);
        reporterThread.start();

        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("\n I can tell you the nth prime number. Enter n:");
            int n = sc.nextInt();
            if(n==0){
                System.out.println("Exit!");
                break;
            }
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    int number = PrimeNumberUtil.calculatePrime(n);
                    System.out.println("\n Result: ");
                    System.out.println("\n Value of "+n+ "th prime: "+number);
                }
            };
            Thread t = new Thread(r);
            threads.add(t);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printThreads(List<Thread> threads) {
        System.out.println("\n Threads status: ");
        threads.forEach( thread -> {
            System.out.println(thread.getName()+" : "+thread.getState()+" ");
        });
        System.out.println("");
    }
}
