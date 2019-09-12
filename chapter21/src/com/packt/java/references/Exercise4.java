package com.packt.java.references;

import java.lang.ref.SoftReference;

public class Exercise4 {
    public static void main(String[] args) throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();

        SoftReference<ShoppingCart> softReference = new SoftReference<>(shoppingCart);

        checkSoftReference(softReference);

        shoppingCart = null;

        System.gc();

        Thread.sleep(5000);

        checkSoftReference(softReference);

        ShoppingCart rescuedCart = softReference.get();
    }

    private static void checkSoftReference(SoftReference<ShoppingCart> softReference) {
        ShoppingCart shoppingCart = softReference.get();
        System.out.println(String.format("ShoppingCart was %scleared.",
                (shoppingCart == null ? "" : "not ")));
    }
}
