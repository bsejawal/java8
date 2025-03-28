package com.bsejawal.thread.synchronization;

class Counter{
    int count;
    public synchronized void increment(){
        count++;
    }
}

public class SyncDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            }
        });
        t1.start();
        t1.join();

        t2.start();
        t2.join();

        System.out.println(counter.count);
    }
}
