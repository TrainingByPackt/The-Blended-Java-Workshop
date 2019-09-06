package com.packt.java.threads;

import static java.lang.Thread.yield;
import static java.util.Arrays.asList;

public class Main {
    static class MyOwnThread implements Runnable {
        public void run() {
            System.out.println(Thread.currentThread().getName() +
                            " running");
            System.out.println(Thread.currentThread().getName() +
                            ": ID " +
                            Thread.currentThread().getId());
            System.out.println(Thread.currentThread().getName() +
                            ": Priority " +
                            Thread.currentThread().getPriority());

            for (int i = 0; i < 100; i++) {
                yield();
                System.out.println(Thread.currentThread().getName() +
                        " count: " + i);
            }
        }
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new MyOwnThread());
        threadA.setName("A");
        threadA.setPriority(Thread.MAX_PRIORITY);
        Thread threadB = new Thread(new MyOwnThread());
        threadB.setName("B");
        threadB.setPriority(Thread.MIN_PRIORITY);
        Thread threadC = new Thread(new MyOwnThread());
        threadC.setName("C");
        threadC.setPriority(Thread.MIN_PRIORITY);
        Thread threadD = new Thread(new MyOwnThread());
        threadD.setName("D");
        threadD.setPriority(Thread.MIN_PRIORITY);
        Thread threadE = new Thread(new MyOwnThread());
        threadE.setName("E");
        threadE.setPriority(Thread.MIN_PRIORITY);
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadE.start();
    }
}
