package com.packt.java.references;

public class ShoppingCart {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalized");
    }
}
