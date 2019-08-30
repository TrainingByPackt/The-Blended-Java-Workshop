package com.packt.java.threads;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pool {
    static class MyThread implements Runnable {
        private String name;

        MyThread (String name) {
            this.name = name;
        }

        public void pause(int sleepTime) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ie) {
                System.out.println(name + " : Exception: " + ie.getMessage());
            }
        }

        public void run() {
            System.out.println(name + " : start");

            int max = new Random().nextInt(9) + 1;
            for (int i = 0; i < max; i++) {
                System.out.println(name + " : operation: " + i + " of " + max);
                pause(100);
            }
            System.out.println(name + " : stop");
        }
    }

    public static void main(String[] args) {
        int POOL_SIZE = 5;
        int TOTAL_THREADS = 10;

        // create an array of threads
        Runnable[] threads = new MyThread[TOTAL_THREADS];

        // systematically create threads named A, B, C ...
        for(int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(Character.toString((char)('A' + i)));
        }

        // construct the Thread Pool
        ExecutorService pool = Executors.newFixedThreadPool(POOL_SIZE);

        // send the threads to the pool and let it run them
        for (int i = 0; i < threads.length; i++) {
            pool.execute(threads[i]);
        }

        // end
        pool.shutdown();
        System.out.println("the end, my friend");
    }
}
