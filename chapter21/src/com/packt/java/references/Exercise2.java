package com.packt.java.references;

import java.util.WeakHashMap;

public class Exercise2 {
    public static void main(String[] args) throws Exception {
        Student harry = new Student("Harry");
        Student jenny = new Student("Jenny");

        WeakHashMap<Student, Integer> testResults =
                new WeakHashMap<>();

        testResults.put(harry, 23);
        testResults.put(jenny, 25);

        System.out.println("Test results: " + testResults.size());

        // HARRY is dereferenced
        harry = null;
        System.gc();

        Thread.sleep(500);

        System.out.println("Test results: " + testResults.size());
    }
}