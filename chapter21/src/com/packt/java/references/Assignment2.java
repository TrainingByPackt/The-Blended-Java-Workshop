package com.packt.java.references;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class Assignment2 {
    public static void main(String[] args) throws Exception {
        ShoppingCart cart1 = new ShoppingCart();
        ShoppingCart cart2 = new ShoppingCart();
        ShoppingCart cart3 = new ShoppingCart();

        ReferenceQueue<ShoppingCart> referenceQueue = new ReferenceQueue<>();

        WeakReference<ShoppingCart> weakReference1 =
                new WeakReference<>(cart1, referenceQueue);
        WeakReference<ShoppingCart> weakReference2 =
                new WeakReference<>(cart2, referenceQueue);
        WeakReference<ShoppingCart> weakReference3 =
                new WeakReference<>(cart3, referenceQueue);

        countReferenceQueue(referenceQueue);

        cart1 = null;
        cart2 = null;
        cart3 = null;

        System.gc();

        Thread.sleep(100);

        countReferenceQueue(referenceQueue);
    }

    private static void countReferenceQueue(ReferenceQueue<ShoppingCart> referenceQueue) {
        int count = 0;
        while (referenceQueue.poll() != null) {
            count++;
        }

        System.out.println("There were " + count + " items in the queue");
    }
}
