package com.packt.java.references;

import java.util.WeakHashMap;

public class Assignment1 {
    public static void main(String[] args) throws Exception {
        Student harry = new Student("Harry");
        Student jenny = new Student("Jenny");

        WeakHashMap<Student, Result> testResults =
                new WeakHashMap<>();

        testResults.put(harry, new Result(harry, 23));
        testResults.put(jenny, new Result(jenny, 25));

        System.out.println("Test results: " + testResults.size());

        // HARRY is dereferenced
        harry = null;
        System.gc();

        Thread.sleep(5000);

        System.out.println("Test results: " + testResults.size());
    }
}
