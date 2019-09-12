package com.packt.java.references;

public class MyObject {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize called.");
    }
}
