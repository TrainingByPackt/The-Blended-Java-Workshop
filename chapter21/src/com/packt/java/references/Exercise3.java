package com.packt.java.references;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class Exercise3 {
    public static void main(String[] args) throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();

        ReferenceQueue<ShoppingCart> referenceQueue = new ReferenceQueue<>();

        WeakReference<ShoppingCart> weakReference =
                new WeakReference<>(shoppingCart, referenceQueue);

        System.out.println(String.format("ShoppingCart has %sbeen cleared.",
                (referenceQueue.poll() == null ? "not " : "")));

        shoppingCart = null;

        System.gc();

        Thread.sleep(500);

        System.out.println(String.format("ShoppingCart has %sbeen cleared.",
                (referenceQueue.poll() == null ? "not " : "")));

        System.out.println(String.format("ShoppingCart reference %sexist",
                (weakReference.get() == null ? "does not " : "")));
    }
}
