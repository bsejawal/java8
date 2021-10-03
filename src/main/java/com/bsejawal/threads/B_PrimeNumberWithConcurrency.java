package com.bsejawal.threads;

import java.util.Scanner;

public class B_PrimeNumberWithConcurrency {
    public static void main(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("\n I can tell you the nth prime number. Enter n:");
            int n = sc.nextInt();
            if(n==0){
                System.out.println("Exit!!!");
                break;
            }
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    int number = PrimeNumberUtil.calculatePrime(n);
                    System.out.println("\nResult: ");
                    System.out.println("\n Value of "+n+ "th prime: "+number);

                }
            };
            Thread t = new Thread(r);
            t.setDaemon(true);
            t.start();

        }

    }
}
