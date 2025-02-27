package com.bsejawal.thread;

public class Multithreading {
    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            MultithreadThing myThing = new MultithreadThing(i);
            myThing.start();
            boolean alive = myThing.isAlive();
            System.out.println(alive);
        }
    }
}
